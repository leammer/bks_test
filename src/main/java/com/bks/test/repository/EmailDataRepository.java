package com.bks.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bks.test.model.EmailData;

@Repository
public interface EmailDataRepository extends JpaRepository<EmailData, Long> {
	long countByUserId(Long userId);

	boolean existsByEmail(String email);

	Optional<EmailData> deleteByEmail(String email);
}
