package com.cabal.challenge.service;

import com.cabal.challenge.model.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email-service", url = "localhost:8084")
public interface EmailService {
	
	@GetMapping(value = "/emails/search/findAllByCommerce")
	PagedModel<Email> findByCommerce(@RequestParam("commerce") Long commerce);
	
}
