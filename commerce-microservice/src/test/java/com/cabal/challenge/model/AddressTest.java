package com.cabal.challenge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private Address address = createAddress();

    @Test
    void getId() {

        //given
        final Long expectedId = 1L;

        //when
        address.setId(1L);

        //then
        assertThat(address.getId()).isEqualTo(expectedId);
    }

    @Test
    void getCep() {

        //given
        final String expectedCep = "72445050";

        //when
        address.setCep("72445050");

        //then
        assertThat(address.getCep()).isEqualTo(expectedCep);

    }

    @Test
    void getPublicPlace() {

        //given
        final String expectedPublicPlace = "A Public Place";

        //when
        address.setPublicPlace("A Public Place");

        //then
        assertThat(address.getPublicPlace()).isEqualTo(expectedPublicPlace);

    }

    @Test
    void getNeighborhood() {

        //given
        final String expectedNeighborhood = "A neighborhood";

        //when
        address.setNeighborhood("A neighborhood");

        //then
        assertThat(address.getNeighborhood()).isEqualTo(expectedNeighborhood);

    }

    @Test
    void getCity() {

        //given
        final String expectedCity = "Brasilia";

        //when
        address.setCity("Brasilia");

        //then
        assertThat(address.getCity()).isEqualTo(expectedCity);

    }

    @Test
    void getUf() {

        //given
        final String expectedUf = "DF";

        //when
        address.setUf("DF");

        //then
        assertThat(address.getUf()).isEqualTo(expectedUf);
    }

    @Test
    void getComplement() {

        //given
        final String expectedComplement = "A simple complement";

        //when
        address.setComplement("A simple complement");

        //then
        assertThat(address.getComplement()).isEqualTo(expectedComplement);
    }

    private Address createAddress() {
        return new Address();
    }
}