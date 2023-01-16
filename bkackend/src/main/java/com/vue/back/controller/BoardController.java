package com.vue.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.BoardDto;
import com.vue.back.dto.BoardGoodBadCntDto;
import com.vue.back.dto.BoardGoodBadDto;
import com.vue.back.dto.BoardModifyDto;
import com.vue.back.dto.BoardTypeDto;
import com.vue.back.dto.PageDto;
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

	@PostMapping(value = "/api/boardSave", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE } )
	public JSONObject boardSave(@RequestBody BoardDto boardDto, HttpServletRequest request) {
		log.info(">>>boardSave check 1");
		
		JSONObject result = new JSONObject();
		try {
			boardService.insertBoard(boardDto);
			result.put("result", 200);
		} catch (Exception e) {
			result.put("result", 500);
		}
		return result;
	}
	
	@PostMapping(value = "/api/boardList") 
	public JSONObject boardList(@RequestBody PageDto pageDto) {
		List<BoardDto> list = boardService.getList(pageDto);
		int listCnt = boardService.getTotalCnt(pageDto);
		JSONObject result = new JSONObject();
		if (list.size() > 0) {
			result.put("boardList", list);
			result.put("listCnt", listCnt);
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}
		return result;
	}

	@PostMapping(value = "/api/boardView/{uid}")
	public JSONObject boardDetail(@PathVariable("uid") long uid) {
		BoardDto boardDto = boardService.getDetail(uid);
		JSONObject result = new JSONObject();
		
		if (boardDto != null) {
			result.put("board", boardDto);
			result.put("result", 200);
		} else {
			result.put("result", 500);
		}

		return result;
	}
	
	@PostMapping(value = "/api/boardDelete/{uid}")
	public JSONObject boardRemove(@PathVariable("uid") long uid) {
		System.out.println("uid >> " + uid);
		int isUp = boardService.removeBoard(uid);
		JSONObject result = new JSONObject();
		
		if(isUp > 0) {
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		return result;
	}
	
	@PostMapping(value = "/api/getBoard/{uid}")
	public JSONObject getMyBoard(@RequestBody BoardDto boardDto) {
		JSONObject result = new JSONObject();
		BoardDto isUp = boardService.getMyBoard(boardDto);
		if(isUp != null) {
			result.put("board", isUp);
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		return result;
	}
	
	@PostMapping(value = "/api/modifySave")
	public JSONObject modifyBoard(@RequestBody BoardModifyDto boardModifyDto) {
		JSONObject result = new JSONObject();
		log.info(">>>>>>>>modify : " + boardModifyDto.toString());
		try {
			boardService.modifyBoard(boardModifyDto);
			result.put("result", 200);
		} catch (Exception e) {
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
		BoardGoodBadCntDto cntDto = boardService.getGoodBadCnt(boardGoodBadDto.getMother_uid());
		
		result.put("cnt", cntDto);
		result.put("result", 200);
		
		return result;
	}
}
