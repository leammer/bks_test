package com.bks.test.service;

import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDataDto;
import com.bks.test.dto.UserFullDataDto;

import org.springframework.data.domain.Page;

import java.lang.Long;

public interface UserService {
	Page<UserFullDataDto> getAll(String filter, Integer number, Integer size, String sortValue);

	UserFullDataDto getUserById(Long id);

	UserFullDataDto updateUser(Long userId, UserDataDto user);

	void deleteEmailData(Long userId, EmailDataDto email);

	EmailDataDto saveEmailData(Long userId, EmailDataDto email);

	void deletePhoneData(Long userId, PhoneDataDto phone);

	PhoneDataDto savePhoneData(Long userId, PhoneDataDto phone);
	
	org.springframework.security.core.userdetails.User findUserByUsername(String username);
}
