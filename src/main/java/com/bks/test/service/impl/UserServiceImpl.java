package com.bks.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDataDto;
import com.bks.test.dto.UserFullDataDto;
import com.bks.test.model.PhoneData;
import com.bks.test.model.QUser;
import com.bks.test.model.User;
import com.bks.test.repository.PhoneDataRepository;
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
	private PhoneDataRepository phoneRepository;

	@Autowired
	private MappingUtils mappingUtils;

	@Override
	public Page<UserFullDataDto> getAll(String filter, Integer number, Integer size, String sortValue) {
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
	public UserFullDataDto getUserById(Long id) {
		User entity = this.userRepository.findById(id).get();
		UserFullDataDto dto = this.mappingUtils.mapToDto(entity);
		return dto;
	}

	@Override
	public void deleteEmailData(Long userId, EmailDataDto email) {
		// TODO
	}

	@Override
	public EmailDataDto updateEmailData(Long userId, EmailDataDto email) {
		// TODO
		return null;
	}

	@Override
	public EmailDataDto addEmailData(Long userId, EmailDataDto email) {
		// TODO
		return null;
	}

	@Override
	public void deletePhoneData(Long userId, PhoneDataDto phone) {
		if (this.phoneRepository.countByUserId(userId) <= 1) {
			throw new RuntimeException("User must have at least one phone number");
		}
		this.phoneRepository.deleteById(phone.getId());
	}

	@Override
	public PhoneDataDto updatePhoneData(Long userId, PhoneDataDto phone) {
		if (this.phoneRepository.existsByPhone(phone.getPhone())) {
			throw new RuntimeException("Phone number is already used");
		}
		PhoneData entity = this.mappingUtils.mapToEntity(phone);
		return this.mappingUtils.mapToDto(this.phoneRepository.saveAndFlush(entity));
	}

	@Override
	public PhoneDataDto addPhoneData(Long userId, PhoneDataDto phone) {
		if (this.phoneRepository.existsByPhone(phone.getPhone())) {
			throw new RuntimeException("Phone number is already used");
		}
		return null;
	}

	@Override
	public UserFullDataDto updateUser(Long userId, UserDataDto user) {
		User entity = this.userRepository.findById(userId).get();
		entity.setName(user.getName());
		entity.setDateOfBirth(user.getDateOfBirth());
		return this.mappingUtils.mapToDto(this.userRepository.saveAndFlush(entity));
	}
}
