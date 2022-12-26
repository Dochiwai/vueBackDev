package com.vue.back.dto;

import java.util.List;

import lombok.Data;

@Data
public class AnswerDto {
	
	private String questionNo;
	private List<String> userAnswer;
	
}
