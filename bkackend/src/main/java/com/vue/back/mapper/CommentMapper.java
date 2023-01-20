package com.vue.back.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.CommentDto;

@Mapper
public interface CommentMapper {

	void commentWrite(CommentDto commentDto);
	
}
