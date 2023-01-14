package com.vue.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadCntDto;
import com.vue.back.dto.BoardGoodBadDto;
import com.vue.back.dto.BoardModifyDto;
import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.PageDto;
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
	public List<BoardDto> getList(PageDto pageDto) {
		log.info(">>>BoardList check 2");
		return boardMapper.getBoardList(pageDto);
	}

	@Override
	public BoardDto getDetail(long uid) {
		log.info(">>>BoardDetail check 2");
		boardMapper.readViewCnt(uid);
		return boardMapper.getBoardDetail(uid);
	}

	@Override
	public BoardGoodBadDto getGoodBadBoard(BoardGoodBadDto dto) {
		return boardMapper.getGoodBadBoard(dto);
	}

	@Override
	public void updateGoodBad(BoardGoodBadDto dto) {
		boardMapper.updateGoodBad(dto);
	}

	@Override
	public void insertGoodBad(BoardGoodBadDto dto) {
		boardMapper.insertGoodBad(dto);
	}

	@Override
	public BoardGoodBadCntDto getGoodBadCnt(long mother_uid) {
		return boardMapper.getGoodBadCnt(mother_uid);
	}

	@Override
	public int getTotalCnt(PageDto pageDto) {
		return boardMapper.getTotalCnt(pageDto);
	}

	@Override
	public int removeBoard(long uid) {
		return boardMapper.removeBoard(uid);
	}

	@Override
	public BoardDto getMyBoard(BoardDto boardDto) {
		return boardMapper.getMyBoard(boardDto);
	}

	@Override
	public void modifyBoard(BoardModifyDto boardModifyDto) {
		boardMapper.modifyBoard(boardModifyDto);
		
	}

	
}
