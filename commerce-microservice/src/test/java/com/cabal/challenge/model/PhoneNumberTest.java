package com.cabal.challenge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    private PhoneNumber phoneNumber = createPhoneNumber();

    @Test
    void getId() {

        //given
        final Long expectedId = 1L;

        //when
        phoneNumber.setId(1L);

        //then
        assertThat(phoneNumber.getId()).isEqualTo(expectedId);

    }

    @Test
    void getPhone() {

        //given
        final String expectedPhone = "986541365";

        //when
        phoneNumber.setPhone("986541365");

        //then
        assertThat(phoneNumber.getPhone()).isEqualTo(expectedPhone);

    }

    @Test
    void getPhoneNumberType() {

        //given
        final String expectedPhoneNumberType = "Personal";

        //when
        phoneNumber.setPhoneNumberType("Personal");

        //then
        assertThat(phoneNumber.getPhoneNumberType()).isEqualTo(expectedPhoneNumberType);

    }

    private PhoneNumber createPhoneNumber() {
        return new PhoneNumber();
    }

}