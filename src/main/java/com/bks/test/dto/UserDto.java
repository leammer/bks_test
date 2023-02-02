package com.bks.test.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	@NotBlank
	@Size(max = 500)
	private String name;

	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}$")
	private String dateOfBirth;

	@Size(min = 8, max = 500)
	private String password;

	private Set<PhoneDataDto> phones;

	private Set<EmailDataDto> emails;
}
