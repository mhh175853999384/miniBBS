package com.mhh.service.impl;

import com.mhh.pojo.BlogCategory;
import com.mhh.mapper.BlogCategoryMapper;
import com.mhh.service.BlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

}
