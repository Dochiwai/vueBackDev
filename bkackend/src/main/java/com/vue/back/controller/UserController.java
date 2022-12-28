package com.vue.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.UserDto;
import com.vue.back.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/api/login" )
	public JSONObject Login(
			HttpServletRequest request,
			@RequestBody UserDto dto
			) {
		
		JSONObject result = new JSONObject();
		result.put("result", 200);
		
		System.out.println(result.toString());
		return result;
	}
	
}
