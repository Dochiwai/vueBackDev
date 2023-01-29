package com.vue.back.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.vue.back.dto.UserDto;
import com.vue.back.dto.UserUpdateDto;

@Mapper
public interface UserMapper {

	UserDto getUser(String user);

	void signUpUser(UserDto user);

	UserDto getUserByUserDto(UserDto dto);

	UserDto getUserInfo(UserDto user);

	void updateUser(UserUpdateDto user);

	void withdrawalUser(UserDto user);

}
