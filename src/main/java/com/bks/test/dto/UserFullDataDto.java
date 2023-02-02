package com.bks.test.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFullDataDto {

	private Long id;

	@NotBlank
	@Size(max = 500)
	private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Past(message = "The date of birth must be in the past.")
	private String dateOfBirth;

	@Size(min = 8, max = 500)
	private String password;

	private Set<PhoneDataDto> phones;

	private Set<EmailDataDto> emails;
}
