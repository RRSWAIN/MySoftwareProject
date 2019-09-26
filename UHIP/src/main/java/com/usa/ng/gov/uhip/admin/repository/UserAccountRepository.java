package com.usa.ng.gov.uhip.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.ng.gov.uhip.admin.entity.UserAccountEntity;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable> {

@Query(name = "from UserAccountEntity where email=:emailId")
public UserAccountEntity findByEmail(String emailId);



}
