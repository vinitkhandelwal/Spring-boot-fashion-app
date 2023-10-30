package com.ecommerce.fashionrent;

import com.ecommerce.fashionrent.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class FashionRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionRentalApplication.class, args);
	}
}
