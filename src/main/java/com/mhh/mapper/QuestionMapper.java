package com.mhh.mapper;

import com.mhh.pojo.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


public interface QuestionMapper extends BaseMapper<Question> {

    void updateAvatarByUid(@Param("avatar") String avatar, @Param("uid") String uid);
}
