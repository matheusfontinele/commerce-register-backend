package com.cabal.challenge.service;

import com.cabal.challenge.model.PhoneNumber;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "phone-number-service", url = "localhost:8083")
public interface PhoneNumberService {
	
	@GetMapping(value = "/phoneNumbers/search/findAllByCommerce")
	PagedModel<PhoneNumber> findByCommerce(@RequestParam("commerce") Long commerce);
	
}