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

	EmailDataDto updateEmailData(Long userId, EmailDataDto email);

	EmailDataDto addEmailData(Long userId, EmailDataDto email);

	void deletePhoneData(Long userId, PhoneDataDto phone);

	PhoneDataDto updatePhoneData(Long userId, PhoneDataDto phone);

	PhoneDataDto addPhoneData(Long userId, PhoneDataDto phone);
}