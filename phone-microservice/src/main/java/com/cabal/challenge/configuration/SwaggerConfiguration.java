package com.cabal.challenge.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	@Value("${project.version}")
	private String version;
	
	@Value("${project.description}")
	private String description;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				       .apiInfo(apiInfo())
				       .enable(true)
				       .select()
				       .paths(PathSelectors.ant("/phoneNumbers/**"))
				       .build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				       .title("Phone Number Service API Documentation")
				       .description(description)
				       .version(version)
				       .build();
	}
	
}