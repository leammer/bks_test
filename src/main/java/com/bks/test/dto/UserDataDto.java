package com.bks.test.dto;

import java.time.LocalDate;

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
public class UserDataDto {

	@NotBlank(message = "Username must contain at least one non-whitespace character")
	@Size(max = 500, message = "Username couldn't be longer than 500 characters")
	private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Past(message = "The date of birth must be in the past.")
	private LocalDate dateOfBirth;

}
