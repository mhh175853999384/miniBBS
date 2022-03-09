package com.mhh.service.impl;

import com.mhh.pojo.Blog;
import com.mhh.mapper.BlogMapper;
import com.mhh.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
