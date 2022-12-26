package com.vue.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vue.back.dto.AnswerDto;
import com.vue.back.dto.SurveyDto;
import com.vue.back.dto.UserDto;
import com.vue.back.service.SurveyService;


@Controller
public class TestController {
	
	@Autowired
	SurveyService surveyService;
	
	@PostMapping(value = "/api/questionSave" , produces="text/plain;charset=UTF-8")
	public String questionSave(
			HttpServletRequest request,
			@RequestBody List<SurveyDto> dto ) {
		
		for(int i = 0; i < dto.size(); i++) {
			surveyService.QuestionSave(dto.get(i));
		}
		
		
		return "gd";
	}
	
	@PostMapping(value = "/api/answerSave" , produces="text/plain;charset=UTF-8")
	public String answerSave(
			HttpServletRequest request,
			@RequestBody List<AnswerDto> dto ) {
		
		for(int i = 0; i < dto.size(); i++) {
			System.out.println(dto.get(i));
		}
		
		return "gd";
	}
	
}
