package com.cabal.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	
	private Long id;
	private String cep;
	private String publicPlace;
	private String neighborhood;
	private String city;
	private String uf;
	private String complement;
	
}
