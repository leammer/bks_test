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
import com.bks.test.dto.UserDataDto;
import com.bks.test.dto.UserFullDataDto;
import com.bks.test.service.UserService;

@RestController
@RequestMapping(USER_REST_CONTROLLER_MAPPING)
public class UserRestController {
	@Autowired
	private UserService service;

	@GetMapping
	public Page<UserFullDataDto> getAllUsers(@RequestParam Optional<String> filter,
			@RequestParam(defaultValue = "0") Integer number, @RequestParam(defaultValue = "20") Integer size,
			@RequestParam Optional<String> sort) {
		String filterValue = filter.orElse("");
		String sortValue = sort.orElse("");
		return this.service.getAll(filterValue, number, size, sortValue);
	}

	@GetMapping(BY_ID)
	public UserFullDataDto getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@PutMapping(BY_ID)
	public UserFullDataDto updateUserData(@PathVariable Long id, @RequestBody @Valid UserDataDto user) {
		return service.updateUser(id, user);
	}

	@DeleteMapping(BY_ID + EMAIL_DATA)
	public void deleteEmailData(@PathVariable Long id, @RequestBody @Valid EmailDataDto email) {
		service.deleteEmailData(id, email);
	}

	@PutMapping(BY_ID + EMAIL_DATA)
	public EmailDataDto updateEmailData(@PathVariable Long id, @RequestBody @Valid EmailDataDto email) {
		return service.saveEmailData(id, email);
	}

	@PostMapping(BY_ID + EMAIL_DATA)
	public EmailDataDto addEmailData(@PathVariable Long id, @RequestBody @Valid EmailDataDto email) {
		return service.saveEmailData(id, email);
	}

	@DeleteMapping(BY_ID + PHONE_DATA)
	public void deletePhoneData(@PathVariable Long id, @RequestBody @Valid PhoneDataDto phone) {
		service.deletePhoneData(id, phone);
	}

	@PutMapping(BY_ID + PHONE_DATA)
	public PhoneDataDto updatePhoneData(@PathVariable Long id, @RequestBody @Valid PhoneDataDto phone) {
		return service.savePhoneData(id, phone);
	}

	@PostMapping(BY_ID + PHONE_DATA)
	public PhoneDataDto addPhoneData(@PathVariable Long id, @RequestBody @Valid PhoneDataDto phone) {
		return service.savePhoneData(id, phone);
	}
}
