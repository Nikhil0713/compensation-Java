package com.capstone.compensation.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capstone.compensation.entity.CompensationEntity;


@Repository
public interface UserComepnsationRepository extends JpaRepository<CompensationEntity, Long>  {
	Optional<CompensationEntity> deleteByplanId(Long planId);
	Optional<CompensationEntity> findByplanId(Long planId);
	
	@Query(nativeQuery = true,
	           value = "select * from  compensation_Table")
	    List<CompensationEntity>  fetchCompensationDetails();
	    

}
