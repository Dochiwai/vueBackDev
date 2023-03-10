package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardTypeDto {

	private int uid;
	private String type;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	
}
