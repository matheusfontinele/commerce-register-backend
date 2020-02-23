package com.cabal.challenge.configuration;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

import static org.assertj.core.api.Assertions.assertThat;

class SwaggerConfigurationTest {

    @Test
    public void whenBuilt_thenGenerateSwaggerApi() {
        //given
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

        //when
        Docket docketApi = swaggerConfiguration.api();

        //then
        assertThat(docketApi).isNotNull();
    }
}