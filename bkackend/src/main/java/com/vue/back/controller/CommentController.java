package com.vue.back.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.CommentDto;
import com.vue.back.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping(value = "/api/commentSave")
	public JSONObject commentWrite(@RequestBody CommentDto commentDto) {
		JSONObject result = new JSONObject();
		try {
			commentService.commentWrite(commentDto);
			result.put("result", 200);
		} catch (Exception e) {
			result.put("result", 500);
		}
		return result;
	}
	@PostMapping(value = "/api/commentView/{uid}")
	public JSONObject commentView(@PathVariable("uid") long uid) {
		log.info(">>>유아이디" + uid);
		JSONObject result = new JSONObject();
		List<CommentDto> commentList = commentService.commentView(uid);
		log.info(">>>>코멘트" + commentList);
		
		if(commentList.size() > 0) {
			result.put("commentList", commentList);
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		return result;
	}

}
