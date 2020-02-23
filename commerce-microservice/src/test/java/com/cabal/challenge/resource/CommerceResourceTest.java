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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.PagedModel;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CommerceMicroserviceApplication.class)
@AutoConfigureMockMvc
public class CommerceResourceTest {

    private Commerce commerce = createCommerce(1L, "86774251000149");

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CommerceRepository commerceRepository;

    PhoneNumberService phoneNumberService = Mockito.mock(PhoneNumberService.class);

    @MockBean
    EmailService emailService;

    @MockBean
    AddressService addressService;

    @MockBean
    CommerceResource commerceResource;

    @Test
    public void whenSlashCommerces_thenReturnAllCommerces() throws Exception {

        //given
        final Long commerceId                     = commerce.getId();
        final Address address                     = createAddress();
        final ArrayList<Email> emails             = createEmails();
        final ArrayList<Commerce> commerces       = createCommerces();
        final ArrayList<PhoneNumber> phoneNumbers = createPhones();

        //when
        when(commerceRepository.findAll()).thenReturn(commerces);

        when(phoneNumberService.findByCommerce(commerceId))
                .thenReturn(createPhoneNumberPageModel());

        when(emailService.findByCommerce(commerceId))
                .thenReturn(createEmailPageModel());

        when(addressService.findByCommerce(commerceId))
                .thenReturn(address);

        //then
        mockMvc.perform(get("/commerces"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.emails[0].email", is("gib.son@lifehx.com")));

    }

    private Commerce createCommerce(Long id, String cnpj) {
        return new Commerce(id, cnpj, "Nerds Burger", null, null, null);
    }

    private ArrayList<Commerce> createCommerces() {

        ArrayList<Commerce> commerces = new ArrayList<>();
        Commerce nerdsBurger = new Commerce(1L, "86774251000149", "Nerds Burger", null, null, null);
        Commerce mcDonalds = new Commerce(2L, "84048320000101", "Mc Donald's", null, null, null);

        commerces.add(nerdsBurger);
        commerces.add(mcDonalds);

        return commerces;

    }

    private PagedModel<PhoneNumber> createPhoneNumberPageModel() {
        return new PagedModel<>(createPhones(), new PagedModel.PageMetadata(1L, 1L, 1L, 1L), Collections.emptyList());
    }

    private PagedModel<Email> createEmailPageModel() {
        return new PagedModel<>(createEmails(), new PagedModel.PageMetadata(1L, 1L, 1L, 1L), Collections.emptyList());
    }

    private ArrayList<PhoneNumber> createPhones() {

        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

        PhoneNumber gibsonNumber  = new PhoneNumber();
        PhoneNumber jacksonNumber = new PhoneNumber();

        gibsonNumber.setId(1L);
        gibsonNumber.setPhone("983131695");
        gibsonNumber.setPhoneNumberType("Personal");

        jacksonNumber.setId(2L);
        jacksonNumber.setPhone("98271145");
        jacksonNumber.setPhoneNumberType("Business");

        phoneNumbers.add(gibsonNumber);
        phoneNumbers.add(jacksonNumber);

        return phoneNumbers;
    }

    private ArrayList<Email> createEmails() {

        ArrayList<Email> emails = new ArrayList<>();

        Email gibsonEmail  = new Email();
        Email jacksonEmail = new Email();

        gibsonEmail.setId(1L);
        gibsonEmail.setEmail("gib.son@lifehx.com");

        jacksonEmail.setId(2L);
        jacksonEmail.setEmail("jack.son@lifehx.com");

        emails.add(gibsonEmail);
        emails.add(jacksonEmail);

        return emails;
    }

    private Address createAddress() {

        Address gibsonAddress  = new Address();

        gibsonAddress.setId(1L);
        gibsonAddress.setCep("72445050");
        gibsonAddress.setComplement(null);
        gibsonAddress.setCity("Brasilia");
        gibsonAddress.setUf("DF");
        gibsonAddress.setNeighborhood("A Simple Neighborhood");
        gibsonAddress.setPublicPlace("A Simple Public Place");

        return gibsonAddress;
    }


}