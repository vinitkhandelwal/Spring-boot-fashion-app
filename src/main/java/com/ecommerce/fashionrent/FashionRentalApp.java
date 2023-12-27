package com.ecommerce.fashionrent;

import com.ecommerce.fashionrent.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class FashionRentalApp {

	public static void main(String[] args) {
		SpringApplication.run(FashionRentalApp.class, args);
	}
}
