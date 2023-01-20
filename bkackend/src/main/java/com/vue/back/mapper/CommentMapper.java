package com.vue.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.CommentDto;

@Mapper
public interface CommentMapper {

	void commentWrite(CommentDto commentDto);

	List<CommentDto> commentView(long uid);
	
}