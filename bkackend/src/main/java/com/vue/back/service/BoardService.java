package com.vue.back.service;

import java.util.List;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadDto;

public interface BoardService {

	List<BoardTypeDto> getBoardType();

	int insertBoard(BoardDto boardDto);

	List<BoardDto> getList();

	BoardDto getDetail(long uid);

	int updateGoodBoard(BoardGoodBadDto boardGoodBadDto);

	int updateBadBoard(BoardGoodBadDto boardGoodBadDto);

	BoardGoodBadDto getGoodBadBoard(long uid);

}
