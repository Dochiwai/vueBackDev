package com.vue.back.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			) throws Exception {
		log.info(">>>login Check 1");
		JSONObject result = new JSONObject();
		if(dto.getEmail() == null || dto.getEmail().equals("") && 
				dto.getPw() == null || dto.getPw().equals("")) {
			result.put("result", 400);
		}else {
			UserDto user = userService.isUser(dto);
			if(user != null) {
				HttpSession httpSession = request.getSession(); 
				httpSession.setAttribute("user", user);
				result.put("user",user);
				result.put("result", 200);			
			}else {
				result.put("result", 500);
			}
		}
		
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
	
	@PostMapping(value = "/api/logout")
	public JSONObject logout(HttpServletRequest request) {
		log.info(">>>logout check 1");
		JSONObject result = new JSONObject();
		request.getSession().removeAttribute("user");
		result.put("result", 200);
		
		return result;
		
	}
}
