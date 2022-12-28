package com.vue.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.BoardCategoryDto;

@Mapper
public interface BoardMapper {

	public List<BoardCategoryDto> getBoardCategory();

}
