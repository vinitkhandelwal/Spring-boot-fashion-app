package com.ecommerce.fashionrent.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
//@SecurityScheme(
//		name = "Bearer Authentication",
//		type = SecuritySchemeType.HTTP,
//		bearerFormat = "JWT",
//		scheme = "bearer"
//)
public class OpenAPIConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ecommerce.fashionrent"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(List.of(apiKey()));
	}

	private ApiKey apiKey() {
		return new ApiKey("Bearer Token", "Authorization", "header");
	}

}