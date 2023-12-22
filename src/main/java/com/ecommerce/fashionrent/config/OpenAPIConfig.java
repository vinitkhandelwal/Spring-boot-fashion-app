package com.ecommerce.fashionrent.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//		name = "Bearer Authentication",
//		type = SecuritySchemeType.HTTP,
//		bearerFormat = "JWT",
//		scheme = "bearer"
//)
public class OpenAPIConfig {

	public static final String SECURITY_SCHEME_NAME = "bearerAuth";
	public static final String SECURITY_SCHEME = "bearer";
	public static final String SECURITY_SCHEME_BEARER_FORMAT = "JWT";

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
				.components(
						new Components()
								.addSecuritySchemes(SECURITY_SCHEME_NAME,
										new io.swagger.v3.oas.models.security.SecurityScheme()
												.name(SECURITY_SCHEME_NAME)
												.type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
												.scheme(SECURITY_SCHEME)
												.bearerFormat(SECURITY_SCHEME_BEARER_FORMAT)
								)
				);
	}


}