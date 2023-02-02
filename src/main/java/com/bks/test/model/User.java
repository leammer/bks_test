package com.bks.test.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Setter
@Getter
@NoArgsConstructor
public class User {
	@Id
	private Long id;

	@Size(max = 500)
	private String name;

	private Date dateOfBirth;

	@Size(min = 8, max = 500)
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	@OneToMany(mappedBy = "user")
	@Size(min = 1)
	private Set<PhoneData> phones;

	@OneToMany(mappedBy = "user")
	@Size(min = 1)
	private Set<EmailData> emails;

}
