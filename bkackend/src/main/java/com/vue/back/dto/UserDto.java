package com.vue.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	private long uid;
	private String email;
	private String pw;
	private String name;
	private String phone;
	private Date created_at;
	private Date updated_at;
	private int status;
	private int email_check;
}
