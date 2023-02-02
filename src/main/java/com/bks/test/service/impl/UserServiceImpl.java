package com.bks.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDto;
import com.bks.test.model.QUser;
import com.bks.test.model.User;
import com.bks.test.repository.UserRepository;
import com.bks.test.service.UserService;
import com.bks.test.utils.MappingUtils;
import com.bks.test.utils.SortingParameter;
import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MappingUtils mappingUtils;

	@Override
	public Page<UserDto> getAll(String filter, Integer number, Integer size, String sortValue) {
		QUser user = QUser.user;
		BooleanBuilder predicate = new BooleanBuilder();

		if (!filter.isBlank()) {
			predicate.and(user.name.containsIgnoreCase(filter));
		}

		SortingParameter sort = SortingParameter.getSortingParameter(sortValue);

		//@formatter:off
		return this.userRepository
				.findAll(predicate, PageRequest.of(number, size, sort.getSort()))
				.map(mappingUtils::mapToDto);
		//@formatter:on
	}

	@Override
	public UserDto getUserById(Long id) {
		User entity = this.userRepository.findById(id).get();
		UserDto dto = this.mappingUtils.mapToDto(entity);
		return dto;
	}

	@Override
	public UserDto deleteEmailData(Long userId, EmailDataDto email) {
		return null;
	}

	@Override
	public UserDto updateEmailData(Long userId, EmailDataDto email) {
		return null;
	}

	@Override
	public UserDto addEmailData(Long userId, EmailDataDto email) {
		return null;
	}

	@Override
	public UserDto deletePhoneData(Long userId, PhoneDataDto phone) {
		return null;
	}

	@Override
	public UserDto updatePhoneData(Long userId, PhoneDataDto phone) {
		return null;
	}

	@Override
	public UserDto addPhoneData(Long userId, PhoneDataDto phone) {
		return null;
	}

	@Override
	public UserDto updateUser(Long id, UserDto user) {
		return null;
	}
}
