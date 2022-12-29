package com.vue.back.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@PostMapping(value="/api/boardCategory")
	public JSONObject boardCategory(
			HttpServletRequest request
		) {
		
		List<BoardCategoryDto> list = boardService.getBoardCategory();
		
		JSONObject result = new JSONObject();
		if(list.size() > 0) {
			result.put("list", list);
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		
		return result;
	}
	
	@PostMapping(value="/api/boardSave")
	public JSONObject boardSave(@RequestBody BoardDto boardDto, HttpServletRequest request) {
		log.info(">>>boardSave check 1");
		System.out.println(boardDto.toString());
		
		int isOK = boardService.insertBoard(boardDto);
		
		JSONObject result = new JSONObject();
		if(isOK > 0) {
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		return result;
	}
	
	@PostMapping(value="/api/boardList")
	public JSONObject boardList() {
		log.info(">>>> boardList check 1");
		List<BoardDto> list = boardService.getList();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(0).toString());
		}
		
		JSONObject result = new JSONObject();
		if(list.size() > 0) {
			result.put("boardList", list);
			result.put("result", 200);			
		}else {
			result.put("result", 500);
		}
		return result;
	}
}
