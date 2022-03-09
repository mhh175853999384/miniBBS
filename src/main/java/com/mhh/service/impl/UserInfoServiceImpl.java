package com.mhh.service.impl;

import com.mhh.pojo.UserInfo;
import com.mhh.mapper.UserInfoMapper;
import com.mhh.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
