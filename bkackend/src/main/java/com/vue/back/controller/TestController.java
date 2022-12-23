package com.vue.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.SurveyDto;
import com.vue.back.dto.UserDto;


@Controller
public class TestController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/questionSave" , produces="text/plain;charset=UTF-8")
	public String questionSave(
			HttpServletRequest request,
			@RequestBody List<SurveyDto> dto ) {
		
		for(int i = 0; i < dto.size(); i++) {
			System.out.println(dto.get(i).toString());
		}
		
		System.out.println(">>>>>> ?? ");
		
		return "gd";
	}
	
}
