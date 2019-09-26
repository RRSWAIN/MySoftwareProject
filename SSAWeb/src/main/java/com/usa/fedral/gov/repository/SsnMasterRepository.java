package com.usa.fedral.gov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedral.gov.entity.SsnMaster;
@Repository
public interface SsnMasterRepository extends JpaRepository<SsnMaster, Serializable> {

	
		
}
