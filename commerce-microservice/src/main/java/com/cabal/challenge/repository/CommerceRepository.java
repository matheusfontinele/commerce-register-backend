package com.cabal.challenge.repository;

import com.cabal.challenge.model.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommerceRepository extends JpaRepository<Commerce, Long> {

}
