package com.mhh.service.impl;

import com.mhh.pojo.Comment;
import com.mhh.mapper.CommentMapper;
import com.mhh.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
