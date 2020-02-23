package com.cabal.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@GetMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
	
}
