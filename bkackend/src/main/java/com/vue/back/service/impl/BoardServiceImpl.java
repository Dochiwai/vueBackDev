package com.vue.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadDto;
import com.vue.back.mapper.BoardMapper;
import com.vue.back.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardTypeDto> getBoardType() {
		return boardMapper.getBoardType();
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

	@Override
	public BoardDto getDetail(long uid) {
		log.info(">>>BoardDetail check 2");
		return boardMapper.getBoardDetail(uid);
	}

	@Override
	public int updateGoodBoard(BoardGoodBadDto boardGoodBadDto) {
		log.info(">>>BoardGood check 2");
		return boardMapper.updateGoodBoard(boardGoodBadDto);
	}

	@Override
	public int updateBadBoard(BoardGoodBadDto boardGoodBadDto) {
		log.info(">>>BoardBad check 2");
		return boardMapper.updateBadBoard(boardGoodBadDto);
	}


	
}
