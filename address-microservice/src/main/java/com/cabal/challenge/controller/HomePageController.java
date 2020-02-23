package com.cabal.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping(value = "/")
	public String setHomePageIndexUri() {
		return "redirect:swagger-ui.html";
	}
	
}
