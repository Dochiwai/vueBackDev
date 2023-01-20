package com.vue.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.CommentDto;
import com.vue.back.mapper.CommentMapper;
import com.vue.back.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper commentMapper;

	@Override
	public void commentWrite(CommentDto commentDto) {
		commentMapper.commentWrite(commentDto);
		
	}

	@Override
	public List<CommentDto> commentView(long uid) {
		log.info("commentView check2");
		return commentMapper.commentView(uid);
	}
}
