package com.vue.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.back.dto.UserDto;
import com.vue.back.dto.UserUpdateDto;
import com.vue.back.mapper.UserMapper;
import com.vue.back.service.UserService;
import com.vue.back.util.AES256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public boolean signUp(UserDto user) throws Exception {
		
		AES256 aes256 = new AES256();
		
		UserDto tmpUser = userMapper.getUser(user.getEmail());
		if(tmpUser != null) { // 중복된 유저가 있는지 체크
			return false;
		}
		
		if(user.getEmail() == null || user.getEmail().length() == 0) {
			return false;
		}
		if(user.getPw() == null || user.getPw().length() == 0) {
			return false;
		}
		
		//비밀번호 암호화
		user.setPw(aes256.encrypt(user.getPw()));
		
		//맵퍼 전달
		userMapper.signUpUser(user);
		return true;
	}


	@Override
	public UserDto isUser(UserDto dto) throws Exception {

		
		AES256 aes256 = new AES256();
		dto.setPw(aes256.encrypt(dto.getPw()));
		
		UserDto user = userMapper.getUserByUserDto(dto);
		
		
		return user;
	}

	@Override
	public UserDto getUserInfo(UserDto user) {

		return userMapper.getUserInfo(user);
	}


	@Override
	public void updateUser(UserUpdateDto user) throws Exception {

		AES256 aes256 = new AES256();
		user.setPassword(aes256.encrypt(user.getPassword()));
		userMapper.updateUser(user);
	}


	@Override
	public void withdrawalUser(UserDto user) {
		userMapper.withdrawalUser(user);
		
	}

}
