package com.vue.back.dto;

import lombok.Data;

@Data
public class UserUpdateDto {

	String email;
	String password;
	String phone;
	String name;
	
}
