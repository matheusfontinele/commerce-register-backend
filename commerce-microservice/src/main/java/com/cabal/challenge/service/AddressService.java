package com.cabal.challenge.service;

import com.cabal.challenge.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "address-service", url = "localhost:8082")
public interface AddressService {
	
	@GetMapping(value = "/addresses/search/findAllByCommerce")
	Address findByCommerce(@RequestParam("commerce") Long commerce);
	
}