package com.bks.test.model;

import java.math.BigDecimal;
import java.math.MathContext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "account")
	private User user;

	private BigDecimal balance = new BigDecimal(0L);
	
	private BigDecimal maxBalance = new BigDecimal(0L);
}
