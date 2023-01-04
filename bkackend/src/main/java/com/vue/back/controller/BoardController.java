package com.vue.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadDto;
import com.vue.back.dto.UserDto;
import com.vue.back.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {

	@Autowired
	BoardService boardService;

	@PostMapping(value = "/api/boardType")
	public JSONObject boardType(HttpServletRequest request) {

		List<BoardTypeDto> list = boardService.getBoardType();

		JSONObject result = new JSONObject();
		if (list.size() > 0) {
			result.put("list", list);
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}

		return result;
	}

	@PostMapping(value = "/api/boardSave")
	public JSONObject boardSave(@RequestBody BoardDto boardDto, HttpServletRequest request) {
		log.info(">>>boardSave check 1");
		System.out.println(boardDto.toString());

		int isOK = boardService.insertBoard(boardDto);

		JSONObject result = new JSONObject();
		if (isOK > 0) {
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}
		return result;
	}

	@PostMapping(value = "/api/boardList")
	public JSONObject boardList() {
		log.info(">>>> boardList check 1");
		List<BoardDto> list = boardService.getList();
		JSONObject result = new JSONObject();
		if (list.size() > 0) {
			result.put("boardList", list);
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}
		return result;
	}

	@PostMapping(value = "/api/boardView/{uid}")
	public JSONObject boardDetail(@PathVariable("uid") long uid) {
		System.out.println("uid >> " + uid);
		BoardDto boardDto = boardService.getDetail(uid);
		JSONObject result = new JSONObject();
		log.info(boardDto.toString());

		if (boardDto != null) {
			result.put("board", boardDto);
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}

		return result;
	}

	@PostMapping(value = "/api/board/goodBad")
	public JSONObject boardDetailGood(@RequestBody BoardGoodBadDto boardGoodBadDto,
			HttpServletRequest request) {
		
		JSONObject result = new JSONObject();
		BoardGoodBadDto userGoodBad = boardService.getGoodBadBoard(boardGoodBadDto);
		
		if(userGoodBad == null) {
			// 아무것도 안했으면
			boardService.insertGoodBad(boardGoodBadDto);
		}else if(userGoodBad.getGood_bad().equals(boardGoodBadDto.getGood_bad())) {
			//중복
			result.put("result",400);
			return result;
		}else if(!userGoodBad.getGood_bad().equals(boardGoodBadDto.getGood_bad())){
			// 이미 했으면,
			boardService.updateGoodBad(boardGoodBadDto);
		}
		
		result.put("result", 200);
		
		return result;
	}
}
