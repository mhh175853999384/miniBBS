package com.mhh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhh.pojo.Invite;
import com.mhh.pojo.User;
import com.mhh.pojo.UserInfo;
import com.mhh.pojo.UserRole;
import com.mhh.service.InviteService;
import com.mhh.service.UserInfoService;
import com.mhh.service.UserRoleService;
import com.mhh.service.UserService;
import com.mhh.utils.KuangUtils;
import com.mhh.vo.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    InviteService inviteService;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserRoleService roleService;

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    // 注册业务
    @PostMapping("/register")
    public String register(RegisterForm registerForm,Model model){
        KuangUtils.print("注册表单信息："+registerForm.toString());
        // 表单密码重复判断
        if (!registerForm.getPassword().equals(registerForm.getRepassword())){
            model.addAttribute("registerMsg","密码输入有误");
            return "register";
        }
        // 用户名已存在
        User hasUser = userService.getOne(new QueryWrapper<User>().eq("username", registerForm.getUsername()));
        if (hasUser!=null){
            model.addAttribute("registerMsg","用户名已存在");
            return "register";
        }

        // 验证邀请码
        Invite invite = inviteService.getOne(new QueryWrapper<Invite>().eq("code", registerForm.getCode()));
        if (invite==null){
            model.addAttribute("registerMsg","邀请码不存在");
            return "register";
        }else {
            // 邀请码存在，判断邀请码是否有效
            if (invite.getStatus()==1){
                model.addAttribute("registerMsg","邀请码已被使用");
                return "register";
            }else {
                // 构建用户对象
                User user = new User();
                user.setUid(KuangUtils.getUuid()); // 用户唯一id
                user.setRoleId(UUID.randomUUID().toString().replace("-","").substring(3,7));
                user.setUsername(registerForm.getUsername());
                // 密码加密
                String bCryptPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
                user.setPassword(bCryptPassword);
                user.setGmtCreate(KuangUtils.getTime());
                user.setLoginDate(KuangUtils.getTime());
                // 保存对象！
                userService.save(user);
                KuangUtils.print("新用户注册成功："+user);

                // 激活邀请码
                invite.setActiveTime(KuangUtils.getTime());
                invite.setStatus(1);
                if("admin".equals(invite.getCode())){
                    invite.setStatus(0);
                }
                invite.setUid(user.getUid());
                inviteService.updateById(invite);

                // todo: 用户信息
                UserInfo userInfo = new UserInfo();
                userInfoService.save(new UserInfo().setUid(user.getUid()));

                //更新角色表
                UserRole role=new UserRole();
                role.setName("用户"+user.getUid()).setUid(user.getUid());
                roleService.save(role);

                // 注册成功，重定向到登录页面
                return "redirect:/toLogin";
            }
        }
    }

}
