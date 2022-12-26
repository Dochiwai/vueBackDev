package com.vue.back.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.SurveyDto;

@Mapper
public interface SurveyMapper {

	void QuestionSave(SurveyDto dto);

}
