package com.bks.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bks.test.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	//@Query("update account set balance = balance*1.1000 where 1.1000*balance<=max_balance")
	void updateBalanceByTimer();
}
