package com.vue.back.service;

import java.util.List;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.dto.BoardDto;

public interface BoardService {

	List<BoardCategoryDto> getBoardCategory();

	int insertBoard(BoardDto boardDto);

	List<BoardDto> getList();

	BoardDto getDetail(String uid);

	int updateGoodBoard(BoardDto boardDto);

}
