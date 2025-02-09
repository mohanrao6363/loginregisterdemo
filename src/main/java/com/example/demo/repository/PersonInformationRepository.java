package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInformation;

@Repository
public interface PersonInformationRepository extends JpaRepository<PersonInformation, Long>{
	

}
