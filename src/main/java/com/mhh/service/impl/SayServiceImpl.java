package com.mhh.service.impl;

import com.mhh.pojo.Say;
import com.mhh.mapper.SayMapper;
import com.mhh.service.SayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SayServiceImpl extends ServiceImpl<SayMapper, Say> implements SayService {

}
