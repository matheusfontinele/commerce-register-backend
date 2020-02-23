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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMAIL_TBL")
public class Email {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COMMERCE")
	private Long commerce;
	
}
