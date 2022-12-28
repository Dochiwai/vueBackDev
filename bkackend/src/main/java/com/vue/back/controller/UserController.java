package com.vue.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.UserDto;
import com.vue.back.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/api/login" )
	public JSONObject Login(
			HttpServletRequest request,
			@RequestBody UserDto dto
			) {
		
		// 아이디 비번 받았고
		// 받지않았으면 400 에러
		
		// 서비스로 이동
		
		// 유저를 받았으면 세션에 저장 후
		
		// 받지않았으면 result 500 으로 해서 return 
		
		//질문?
		JSONObject result = new JSONObject();
		result.put("result", 200);
		
		return result;
	}
	
	@PostMapping(value = "/api/signUp")
	public JSONObject signup(@RequestBody UserDto user) throws Exception {
		log.info(">>>signUp check 1");
		boolean isUp = userService.signUp(user);
		JSONObject result = new JSONObject();
		if(isUp) {
			result.put("result", 200);
		}else {
			result.put("result", 500);
		}
		
		return result;
	}
}
