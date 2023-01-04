package com.vue.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadDto;

@Mapper
public interface BoardMapper {

	public List<BoardTypeDto> getBoardType();

	public int insertBoard(BoardDto boardDto);

	public List<BoardDto> getBoardList();

	public BoardDto getBoardDetail(long uid);
	
	public void readViewCnt(long uid);

	public int updateGoodBoard(BoardGoodBadDto boardGoodBadDto);

	public int updateBadBoard(BoardGoodBadDto boardGoodBadDto);

	public BoardGoodBadDto getGoodBadBoard(long uid);

}
