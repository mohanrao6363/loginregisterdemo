package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LoginIdentity;
import com.example.demo.entity.PersonInformation;
import com.example.demo.repository.LoginIdentityRepository;
import com.example.demo.repository.PersonInformationRepository;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	PersonInformationRepository personInformationRepository;
	
	@Autowired
	LoginIdentityRepository loginIdentityRepository;
	
	@RequestMapping("login_filter")
	public String login() {
		return "login.html";
	}
	
	@RequestMapping("start")
	public String index(@RequestParam(name = "username") String accountName ,Model model) {
		LoginIdentity loginIdentity = loginIdentityRepository.findByAccountName(accountName).get();
		PersonInformation personInformation = loginIdentity.getPersonInformation();
		model.addAttribute("loginIdentity",loginIdentity);
		model.addAttribute("personInformation",personInformation);
		return "start.html";
	}
	
	@RequestMapping("register")
	public String register(Model model) {
		LoginIdentity loginIdentity = new LoginIdentity();
		PersonInformation personInformation = new PersonInformation();
		model.addAttribute("personInformation", personInformation);
		model.addAttribute("loginIdentity", loginIdentity);
		return "register.html";
	}
	
	@RequestMapping("register/write_in")
	public String registerWriteIn(PersonInformation personInformation, LoginIdentity loginIdentity) {
		System.out.println("test");
		loginIdentity.setPersonInformation(personInformation);
		personInformationRepository.save(personInformation);
		loginIdentityRepository.save(loginIdentity);
		return "registerRedirect.html";
	}


}
