package com.cabal.challenge.repository;

import com.cabal.challenge.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findAllByCommerce(@Param("commerce") Long commerce);
	
}
