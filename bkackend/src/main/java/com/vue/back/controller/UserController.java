package com.vue.back.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.UserDto;
import com.vue.back.dto.UserUpdateDto;
import com.vue.back.service.UserService;
import com.vue.back.util.AES256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/api/login")
	public JSONObject Login(HttpServletRequest request, @RequestBody UserDto dto) throws Exception {
		log.info(">>>login Check 1");
		JSONObject result = new JSONObject();
		if (dto.getEmail() == null || dto.getEmail().equals("") && dto.getPw() == null || dto.getPw().equals("")) {
			result.put("result", 400);
		} else {
			UserDto user = userService.isUser(dto);
			if (user != null) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", user);
				result.put("user", user);
				result.put("result", 200);
			} else {
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
		if (isUp) {
			result.put("result", 200);
		} else {
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
	
	@PostMapping(value = "/api/getUser")
	public JSONObject getMyInfo(@RequestBody UserDto user) {
		log.info("getUserInfo check 1");
		log.info("user: " + user);
		JSONObject result = new JSONObject();
		UserDto isUp = userService.getUserInfo(user);
		if(isUp != null) {
			result.put("user",isUp);
			result.put("result", 200);
		}else {
			result.put("result", 500);	
		}
		return result;
	}
	
	@PostMapping(value = "/api/mypageSave")
	public JSONObject userSave(@RequestBody UserUpdateDto user, HttpServletRequest request) throws Exception {
		log.info("ChangeUserInfo check 1");
		JSONObject result = new JSONObject();
		log.info(">> log : " + user.toString());
		
		try {
			userService.updateUser(user);
			result.put("result", 200);
		}catch (Exception e) {
			result.put("result", 500);
		}
				
		return result;
		
	}
	
	@PostMapping(value = "/api/withdrawal")
	public JSONObject userWithdrawal(@RequestBody UserDto user, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		log.info(">>>check withdrawal 1");
		log.info(">>> check request user" + user.toString());
		try {
			userService.withdrawalUser(user);
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();
			result.put("result", 200);
		} catch (Exception e) {
			result.put("result", 500);
		}
		return result;
	}
}
