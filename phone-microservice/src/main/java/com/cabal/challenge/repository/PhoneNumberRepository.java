package com.cabal.challenge.repository;

import com.cabal.challenge.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

	Collection<PhoneNumber> findAllByCommerce(@Param("commerce") Long commerce);

}
