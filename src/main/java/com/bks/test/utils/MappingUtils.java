package com.bks.test.utils;

import org.mapstruct.Mapper;
import com.bks.test.dto.EmailDataDto;
import com.bks.test.dto.PhoneDataDto;
import com.bks.test.dto.UserDto;
import com.bks.test.model.EmailData;
import com.bks.test.model.PhoneData;
import com.bks.test.model.User;

@Mapper(componentModel = "spring")
public interface MappingUtils {
	UserDto mapToDto(User entity);

	PhoneDataDto mapToDto(PhoneData entity);

	EmailDataDto mapToDto(EmailData entity);
}
