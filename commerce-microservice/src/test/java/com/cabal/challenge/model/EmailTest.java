package com.cabal.challenge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    private Email email = createEmail();

    @Test
    void getId() {

        //given
        final Long expectedId = 1L;

        //when
        email.setId(1L);

        //then
        assertThat(email.getId()).isEqualTo(expectedId);

    }

    @Test
    void getEmail() {

        //given
        final String expectedEmail = "gib.son@lifehx.com";

        //when
        email.setEmail("gib.son@lifehx.com");

        //then
        assertThat(email.getEmail()).isEqualTo(expectedEmail);


    }

    private Email createEmail() {
        return new Email();
    }

}