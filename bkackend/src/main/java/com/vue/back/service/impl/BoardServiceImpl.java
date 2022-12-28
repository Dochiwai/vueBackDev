package com.vue.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.mapper.BoardMapper;
import com.vue.back.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardCategoryDto> getBoardCategory() {
		return boardMapper.getBoardCategory();
	}
	
}
