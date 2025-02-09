package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.LoginIdentity;
import com.example.demo.entity.PersonInformation;
import com.example.demo.repository.LoginIdentityRepository;
import com.example.demo.repository.PersonInformationRepository;

@SpringBootTest
class SpringBootLogIn20211129ApplicationTests {
	
	@Autowired
	LoginIdentityRepository loginIdentityRepository;
	
	@Autowired
	PersonInformationRepository personInformationRepository;
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	void contextLoads() throws ParseException {
		Date date = new Date();
		
		PersonInformation p1 = new PersonInformation();
		p1.setName("謝宗元");
		p1.setPhoneNumber("0932736281");
		date = simpleDateFormat.parse("1994-02-28");
		p1.setBirthDate(date);
		
		PersonInformation p2 = new PersonInformation();
		p2.setName("David");
		p2.setPhoneNumber("0909224301");
		date = simpleDateFormat.parse("1991-01-01");
		p2.setBirthDate(date);
		
		LoginIdentity l1 = new LoginIdentity();
		l1.setAccountName("dennesshen");
		l1.setAccountPassword("123456789");
		
		LoginIdentity l2 = new LoginIdentity();
		l2.setAccountName("admin");
		l2.setAccountPassword("admin");
		
		//建立關聯關係
		l1.setPersonInformation(p1);
		l2.setPersonInformation(p2);
		
		
		//執行保存
		personInformationRepository.save(p1);
		personInformationRepository.save(p2);
		loginIdentityRepository.save(l1);
		loginIdentityRepository.save(l2);
		
		
	}

}
