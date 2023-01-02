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

	@PostMapping(value = "/api/boardCategory")
	public JSONObject boardCategory(HttpServletRequest request) {

		List<BoardTypeDto> list = boardService.getBoardCategory();

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

	@PostMapping(value = "/api/board/{uid}/good")
	public JSONObject boardDetailGood(@PathVariable("uid") long uid, @RequestBody BoardGoodBadDto boardGoodBadDto, HttpServletRequest request) {
		log.info(">>>uid = " + uid);
		log.info(">>>boardDto = " + boardGoodBadDto.toString());
		int isOk = boardService.updateGoodBoard(boardGoodBadDto);
		JSONObject result = new JSONObject();
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String email = user.getEmail();
		if (boardGoodBadDto.getCreated_user().equals(email) && boardGoodBadDto.getGood_bad() == "G" ) {
			result.put("result", 400);
		}
		if (isOk > 0) {
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}

		return result;
	}

	@PostMapping(value = "/api/board/{uid}/bad")
	public JSONObject boardDetailBad(@PathVariable("uid") long uid, @RequestBody BoardGoodBadDto boardGoodBadDto) {
		int isOk = boardService.updateBadBoard(boardGoodBadDto);

		JSONObject result = new JSONObject();
		if (isOk > 0) {
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}

		return result;
	}
}
