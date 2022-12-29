package com.vue.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.mapper.BoardMapper;
import com.vue.back.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardCategoryDto> getBoardCategory() {
		return boardMapper.getBoardCategory();
	}

	@Override
	public int insertBoard(BoardDto boardDto) {
		log.info(">>>insert board check 2");
		return boardMapper.insertBoard(boardDto);
	}

	@Override
	public List<BoardDto> getList() {
		log.info(">>>BoardList check 2");
		return boardMapper.getBoardList();
	}
	
}
