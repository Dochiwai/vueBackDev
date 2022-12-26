package com.vue.back.service;

import org.springframework.stereotype.Service;

import com.vue.back.dto.SurveyDto;

@Service
public interface SurveyService {

	void QuestionSave(SurveyDto surveyDto);
	
}
