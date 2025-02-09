package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginIdentity;

@Repository
public interface LoginIdentityRepository extends JpaRepository<LoginIdentity, Long>{
	
	Optional<LoginIdentity> findByAccountName(String accountName);

}
