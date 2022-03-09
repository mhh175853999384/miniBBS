package com.mhh.mapper;

import com.mhh.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


public interface CommentMapper extends BaseMapper<Comment> {

    void updateAvatar(@Param("avatar") String avatar, @Param("uid") String uid);
}
