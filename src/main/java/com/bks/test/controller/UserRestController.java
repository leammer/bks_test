package com.bks.test.controller;

import static com.bks.test.utils.AppConstants.BY_ID;
import static com.bks.test.utils.AppConstants.USER_REST_CONTROLLER_MAPPING;
import static com.bks.test.utils.AppConstants.EMAIL_DATA;
import static com.bks.test.utils.AppConstants.PHONE_DATA;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDto;
import com.bks.test.service.UserService;

@RestController
@RequestMapping(USER_REST_CONTROLLER_MAPPING)
public class UserRestController {
	@Autowired
	private UserService service;

	@GetMapping
	public Page<UserDto> getAllUsers(@RequestParam Optional<String> filter,
			@RequestParam(defaultValue = "0") Integer number, @RequestParam(defaultValue = "20") Integer size,
			@RequestParam Optional<String> sort) {
		String filterValue = filter.orElse("");
		String sortValue = sort.orElse("");
		return this.service.getAll(filterValue, number, size, sortValue);
	}

	@GetMapping(BY_ID)
	public UserDto getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@PutMapping(BY_ID)
	public UserDto updateUserData(@PathVariable Long userId, @RequestBody @Valid UserDto user) {
		return service.updateUser(userId, user);
	}

	@DeleteMapping(BY_ID + EMAIL_DATA)
	public UserDto deleteEmailData(@PathVariable Long userId, @RequestBody @Valid EmailDataDto email) {
		return service.deleteEmailData(userId, email);
	}

	@PutMapping(BY_ID + EMAIL_DATA)
	public UserDto updateEmailData(@PathVariable Long userId, @RequestBody @Valid EmailDataDto email) {
		return service.updateEmailData(userId, email);
	}

	@PostMapping(BY_ID + EMAIL_DATA)
	public UserDto addEmailData(@PathVariable Long userId, @RequestBody @Valid EmailDataDto email) {
		return service.addEmailData(userId, email);
	}

	@DeleteMapping(BY_ID + PHONE_DATA)
	public UserDto deletePhoneData(@PathVariable Long userId, @RequestBody @Valid PhoneDataDto phone) {
		return service.deletePhoneData(userId, phone);
	}

	@PutMapping(BY_ID + PHONE_DATA)
	public UserDto updatePhoneData(@PathVariable Long userId, @RequestBody @Valid PhoneDataDto phone) {
		return service.updatePhoneData(userId, phone);
	}

	@PostMapping(BY_ID + PHONE_DATA)
	public UserDto addPhoneData(@PathVariable Long userId, @RequestBody @Valid PhoneDataDto phone) {
		return service.addPhoneData(userId, phone);
	}

}
