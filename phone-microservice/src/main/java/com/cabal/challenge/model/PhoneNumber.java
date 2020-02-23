package com.cabal.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PHONE_NUMBER_TBL")
public class PhoneNumber {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "PHONE_NUMBER")
	private String phone;
	
	@Column(name = "PHONE_NUMBER_TYPE")
	private String phoneNumberType;
	
	@Column(name = "COMMERCE")
	private Long commerce;
	
}
