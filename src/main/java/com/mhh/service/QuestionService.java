package com.mhh.service;

import com.mhh.pojo.Question;
import com.baomidou.mybatisplus.extension.service.IService;


public interface QuestionService extends IService<Question> {

    void updateAvatar(String avatar, String uid);
}
