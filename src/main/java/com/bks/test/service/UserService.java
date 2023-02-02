package com.bks.test.service;

import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDto;

import org.springframework.data.domain.Page;

import java.lang.Long;

public interface UserService {
	Page<UserDto> getAll(String filter, Integer number, Integer size, String sortValue);

	UserDto getUserById(Long id);

	UserDto updateUser(Long id, UserDto user);

	UserDto deleteEmailData(Long userId, EmailDataDto email);

	UserDto updateEmailData(Long userId, EmailDataDto email);

	UserDto addEmailData(Long userId, EmailDataDto email);

	UserDto deletePhoneData(Long userId, PhoneDataDto phone);

	UserDto updatePhoneData(Long userId, PhoneDataDto phone);

	UserDto addPhoneData(Long userId, PhoneDataDto phone);
}
