package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardModifyDto {
	long uid;
	String title;
	String content;
	Date updated_at;
}
