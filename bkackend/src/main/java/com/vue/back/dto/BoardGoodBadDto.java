package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardGoodBadDto {
	private long uid;
	private long mother_uid;
	private String created_user;
	private String good_bad;
	private Date created_at;
	private Date updated_at;
}
