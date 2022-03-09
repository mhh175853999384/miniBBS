package com.mhh.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhh.mapper.BlogMapper;
import com.mhh.mapper.CommentMapper;
import com.mhh.pojo.*;
import com.mhh.service.*;
import com.mhh.utils.KuangUtils;
import com.mhh.vo.LayerPhoto;
import com.mhh.vo.LayerPhotoData;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class UserController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    BlogService blogService;
    @Autowired
    QuestionService questionService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    CommentMapper commentMapper;

    @GetMapping("/user/{uid}")
    public String userIndex(@PathVariable String uid, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        // 用户的博客列表
        Page<Blog> pageParam = new Page<>(1, 10);
        blogService.page(pageParam,new QueryWrapper<Blog>().eq("author_id", uid)
                                                         .orderByDesc("gmt_create"));
        // 结果
        List<Blog> blogList = pageParam.getRecords();
        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        return "user/index";
    }

    @GetMapping("/user/blog/{uid}/{page}/{limit}")
    public String userIndexBlog(@PathVariable String uid,
                                @PathVariable int page,
                                @PathVariable int limit,
                                Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        // 用户的博客列表
        if (page < 1){
            page = 1;
        }
        Page<Blog> pageParam = new Page<>(page, limit);
        blogService.page(pageParam,new QueryWrapper<Blog>().eq("author_id", uid)
                .orderByDesc("gmt_create"));

        // 结果
        List<Blog> blogList = pageParam.getRecords();
        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        return "user/index";
    }

    @GetMapping("/user/question/{uid}/{page}/{limit}")
    public String userIndexQuestion(@PathVariable String uid,
                                @PathVariable int page,
                                @PathVariable int limit,
                                Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);

        //
        if (page < 1){
            page = 1;
        }
        Page<Question> pageParam = new Page<>(page, limit);
        questionService.page(pageParam,new QueryWrapper<Question>().eq("author_id", uid)
                .orderByDesc("gmt_create"));

        // 结果
        List<Question> blogList = pageParam.getRecords();
        model.addAttribute("questionList",blogList);
        model.addAttribute("pageParam",pageParam);

        return "user/user-question";
    }

    @GetMapping("/user/comment/{uid}/{page}/{limit}")
    public String userIndexComment(@PathVariable String uid,
                                    @PathVariable int page,
                                    @PathVariable int limit,
                                    Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        //
        if (page < 1){
            page = 1;
        }
        Page<Comment> pageParam = new Page<>(page, limit);
        commentService.page(pageParam,new QueryWrapper<Comment>().eq("user_id", uid)
                .orderByDesc("gmt_create"));

        // 结果
        List<Comment> commentList = pageParam.getRecords();
        model.addAttribute("commentList",commentList);
        model.addAttribute("pageParam",pageParam);

        return "user/user-comment";
    }

    // 用户信息回填
    private void userInfoCallBack(String uid,Model model){
        UserInfo userInfo = userInfoService.getById(uid);
        model.addAttribute("userInfo",userInfo);
        if (userInfo.getHobby()!=null && !userInfo.getHobby().equals("")){
            String[] hobbys = userInfo.getHobby().split(",");
            model.addAttribute("infoHobbys",hobbys);
        }
        // 获取用户的问题，博客，回复数
        int blogCount = blogService.count(new QueryWrapper<Blog>().eq("author_id", uid));
        int questionCount = questionService.count(new QueryWrapper<Question>().eq("author_id", uid));
        int commentCount = commentService.count(new QueryWrapper<Comment>().eq("user_id", uid));
        model.addAttribute("blogCount",blogCount);
        model.addAttribute("questionCount",questionCount);
        model.addAttribute("commentCount",commentCount);

    }


    @GetMapping("/user/update-avatar/{uid}")
    public String updateAvatarPage(@PathVariable String uid,Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        return "user/update-avatar";
    }


    // 更新头像
    @PostMapping("/user/update")
    public String toUpdateAvatar(@RequestParam("uploadFile") MultipartFile uploadFile, Model model, HttpSession session){
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/images/avatar";
            String newFilename= UUID.randomUUID().toString().replace("-","")
                    +"."+ FilenameUtils.getExtension(uploadFile.getOriginalFilename());
            uploadFile.transferTo(new File(path,newFilename));
            User loginUser = (User) session.getAttribute("loginUser");
            loginUser.setAvatar(newFilename);
            userService.updateById(loginUser);
            blogMapper.updataAvatar(loginUser.getAvatar(),loginUser.getUid());
            commentMapper.updateAvatar(loginUser.getAvatar(),loginUser.getUid());
            questionService.updateAvatar(loginUser.getAvatar(),loginUser.getUid());
            session.setAttribute("loginUser",loginUser);
            // 用户信息回填
            userInfoCallBack(loginUser.getUid(),model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/update-avatar";
    }

}

