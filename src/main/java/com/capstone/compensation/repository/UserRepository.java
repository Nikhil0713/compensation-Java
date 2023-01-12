package com.capstone.compensation.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.compensation.entity.CompensationEntity;
import com.capstone.compensation.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmailId(String emailId);

	Boolean existsByEmailId(String emailId);
	//Optional<UserEntity> findByUserName(String username);
}