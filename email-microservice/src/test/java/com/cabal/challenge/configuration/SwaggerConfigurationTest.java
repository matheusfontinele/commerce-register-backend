package com.cabal.challenge.configuration;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

import static org.assertj.core.api.Assertions.assertThat;

class SwaggerConfigurationTest {

    @Test
    void apiTest() {

        //given
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

        //when
        Docket api = swaggerConfiguration.api();

        //then
        assertThat(api).isNotNull();

    }

}