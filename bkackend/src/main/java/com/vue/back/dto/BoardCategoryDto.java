package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardCategoryDto {

	private int uid;
	private String type;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	
}
