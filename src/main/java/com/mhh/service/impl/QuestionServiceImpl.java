package com.mhh.service.impl;

import com.mhh.pojo.Question;
import com.mhh.mapper.QuestionMapper;
import com.mhh.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public void updateAvatar(String avatar, String uid) {
        this.baseMapper.updateAvatarByUid(avatar,uid);
    }
}
