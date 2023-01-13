package com.vue.back.service;

import java.util.List;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.PageDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadCntDto;
import com.vue.back.dto.BoardGoodBadDto;

public interface BoardService {

	List<BoardTypeDto> getBoardType();

	int insertBoard(BoardDto boardDto);

	List<BoardDto> getList(PageDto pageDto);

	BoardDto getDetail(long uid);

	BoardGoodBadDto getGoodBadBoard(BoardGoodBadDto dto);

	void updateGoodBad(BoardGoodBadDto boardGoodBadDto);

	void insertGoodBad(BoardGoodBadDto boardGoodBadDto);

	BoardGoodBadCntDto getGoodBadCnt(long mother_uid);

	int getTotalCnt(PageDto pageDto);

}
