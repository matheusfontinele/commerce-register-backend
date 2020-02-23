package com.cabal.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String setHomePageIndexUri() {
        return "redirect:swagger-ui.html";
    }

}
