package com.bks.test.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
public class Account {

	@Id
	private Long id;

	@OneToOne(mappedBy = "account")
	private User user;

	private BigDecimal balance;
}
