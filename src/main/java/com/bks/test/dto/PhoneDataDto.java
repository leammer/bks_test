package com.bks.test.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDataDto {
	private Long id;

	@Pattern(regexp="^[0-9]{11}",message="phone number must contain 11 numbers")
	private String phone;
}
