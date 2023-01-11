package com.vue.back.service;

import com.vue.back.dto.UserDto;
import com.vue.back.dto.UserUpdateDto;

public interface UserService {

	boolean signUp(UserDto user) throws Exception;

	UserDto isUser(UserDto dto) throws Exception;

	UserDto getUserInfo(UserDto user);

	void updateUser(UserUpdateDto user) throws Exception;

}
