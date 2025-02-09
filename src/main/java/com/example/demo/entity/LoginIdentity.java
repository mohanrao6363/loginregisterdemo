package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "loginIdentity")
public class LoginIdentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String accountName;
	
	@Column
	private String accountPassword;
	
	/*
	@Column
	@CreatedDate
	private Date accountBuildTime;
	*/
	
	@ManyToOne
	@JoinColumn(name = "personInformation_id")
	PersonInformation personInformation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	

	public PersonInformation getPersonInformation() {
		return personInformation;
	}

	public void setPersonInformation(PersonInformation personInformation) {
		this.personInformation = personInformation;
	}
	
	
	
}
