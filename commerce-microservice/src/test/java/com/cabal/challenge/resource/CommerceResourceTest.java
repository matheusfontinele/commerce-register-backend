package com.cabal.challenge.resource;

import com.cabal.challenge.CommerceMicroserviceApplication;
import com.cabal.challenge.model.Address;
import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.Email;
import com.cabal.challenge.model.PhoneNumber;
import com.cabal.challenge.repository.CommerceRepository;
import com.cabal.challenge.service.AddressService;
import com.cabal.challenge.service.EmailService;
import com.cabal.challenge.service.PhoneNumberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CommerceMicroserviceApplication.class)
@AutoConfigureMockMvc
public class CommerceResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PhoneNumberService phoneNumberService;

    @Test
    public void whenSlashCommerces_thenReturnAllCommerces() throws Exception {

        mockMvc.perform(get("/commerces"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

    }

}