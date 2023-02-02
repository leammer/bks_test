package com.bks.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.bks.test.model.PhoneData;
import com.bks.test.model.User;

@Repository
public interface PhoneDataRepository extends JpaRepository<PhoneData, Long>, QuerydslPredicateExecutor<User> {
	long countByUserId(Long userId);
	boolean existsByPhone(String phone);
	Optional<PhoneData> deleteByPhone(String phone);
}
