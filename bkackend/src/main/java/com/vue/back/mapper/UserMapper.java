package com.vue.back.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.UserDto;

@Mapper
public interface UserMapper {

	UserDto getUser(String user);

	void signUpUser(UserDto user);

}
