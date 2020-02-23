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
@Entity(name = "ADDRESS_TBL")
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "CEP", nullable = false)
	private String cep;
	
	@Column(name = "PUBLIC_PLACE", nullable = false)
	private String publicPlace;
	
	@Column(name = "NEIGHBORHOOD", nullable = false)
	private String neighborhood;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "UF", nullable = false)
	private String uf;
	
	@Column(name = "COMPLEMENT")
	private String complement;
	
	@Column(name = "COMMERCE")
	private Long commerce;
	
}
