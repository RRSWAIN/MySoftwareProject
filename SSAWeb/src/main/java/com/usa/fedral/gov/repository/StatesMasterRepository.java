package com.usa.fedral.gov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedral.gov.entity.StatesMaster;
@Repository
public interface StatesMasterRepository extends JpaRepository<StatesMaster, Serializable> {
	
	//@Query("SELECT e.statename FROM StatesMaster e")
	//public List<Object> getStateNames();

}
