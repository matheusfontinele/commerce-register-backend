package com.cabal.challenge.controller;

import com.cabal.challenge.EmailMicroserviceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmailMicroserviceApplication.class)
@AutoConfigureMockMvc
class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HomePageController homePageController;

    @Test
    public void whenNullUrl_thenRedirectToSwagger() throws Exception {
        //given
        final String expected = "swagger-ui.html";

        //when
        mockMvc.perform(get("/"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(expected));

    }

    @Test
    public void setHomePageIndexUriReturn_test() {

        //given
        HomePageController homePageController = new HomePageController();
        final String expected = "redirect:swagger-ui.html";

        //when
        String returnedUri = homePageController.setHomePageIndexUri();

        //then
        assertThat(returnedUri).isEqualTo(expected);

    }

    @Test
    void contextLoads() {
        assertThat(homePageController).isNotNull();
    }

}