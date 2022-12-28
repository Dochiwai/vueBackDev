package com.vue.back.service;

import com.vue.back.dto.UserDto;

public interface UserService {

	boolean signUp(UserDto user) throws Exception;

	UserDto isUser(UserDto dto) throws Exception;

}
