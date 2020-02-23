package com.cabal.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMMERCE_TBL")
public class Commerce {
	
	@Id
	@GeneratedValue
	private Long id;

	@CNPJ
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "NAME")
	private String name;
	
	@Transient
	private Address address;
	
	@Transient
	private Collection<PhoneNumber> phoneNumbers;
	
	@Transient
	private Collection<Email> emails;
	
}
