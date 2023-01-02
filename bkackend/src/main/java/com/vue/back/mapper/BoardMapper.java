package com.vue.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public List<BoardCategoryDto> getBoardCategory();

	public int insertBoard(BoardDto boardDto);

	public List<BoardDto> getBoardList();

	public BoardDto getBoardDetail(long uid);

	public int updateGoodBoard(BoardDto boardDto);

	public int updateBadBoard(BoardDto boardDto);

}
