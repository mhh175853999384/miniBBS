package com.mhh.mapper;

import com.mhh.pojo.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


public interface BlogMapper extends BaseMapper<Blog> {

    void updataAvatar(@Param("avatar") String avatar, @Param("uid") String uid);
}
