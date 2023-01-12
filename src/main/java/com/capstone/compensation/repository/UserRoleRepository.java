package com.capstone.compensation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.compensation.entity.UserRoleEntity;
import com.capstone.compensation.model.UserRoles;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
	Optional<UserRoleEntity> findByName(UserRoles name);
}
