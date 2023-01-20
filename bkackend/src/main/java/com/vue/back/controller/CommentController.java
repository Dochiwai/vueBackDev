package com.vue.back.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

}
