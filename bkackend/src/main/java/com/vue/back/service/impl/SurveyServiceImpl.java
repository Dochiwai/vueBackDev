package com.vue.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.SurveyDto;
import com.vue.back.mapper.SurveyMapper;
import com.vue.back.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	SurveyMapper surveyMapper;

	@Override
	public void QuestionSave(SurveyDto dto) {
		surveyMapper.QuestionSave(dto);
	}
}
