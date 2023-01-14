package com.vue.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.PageDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadCntDto;
import com.vue.back.dto.BoardGoodBadDto;
import com.vue.back.dto.BoardModifyDto;

@Mapper
public interface BoardMapper {

	public List<BoardTypeDto> getBoardType();

	public int insertBoard(BoardDto boardDto);

	public List<BoardDto> getBoardList(PageDto pageDto);
	
	public List<BoardDto> getBoardGoodCnt();

	public BoardDto getBoardDetail(long uid);
	
	public void readViewCnt(long uid);

	public BoardGoodBadDto getGoodBadBoard(BoardGoodBadDto dto);

	public void updateGoodBad(BoardGoodBadDto dto);

	public void insertGoodBad(BoardGoodBadDto dto);

	public BoardGoodBadCntDto getGoodBadCnt(long mother_uid);

	public int getTotalCnt(PageDto pageDto);

	public int removeBoard(long uid);

	public BoardDto getMyBoard(BoardDto boardDto);

	public void modifyBoard(BoardModifyDto boardModifyDto);
}
