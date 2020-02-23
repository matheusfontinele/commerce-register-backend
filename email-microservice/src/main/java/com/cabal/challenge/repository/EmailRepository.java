package com.cabal.challenge.repository;

import com.cabal.challenge.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface EmailRepository extends JpaRepository<Email, Long> {
	
	Collection<Email> findAllByCommerce(@Param("commerce") Long commerce);
	
}
