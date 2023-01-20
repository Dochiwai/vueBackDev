package com.vue.back.service;

import java.util.List;

import com.vue.back.dto.CommentDto;

public interface CommentService {

	void commentWrite(CommentDto commentDto);

	List<CommentDto> commentView(long uid);

}
