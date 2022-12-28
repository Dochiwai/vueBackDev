package com.vue.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.BoardCategoryDto;
import com.vue.back.service.BoardService;

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
	
}
