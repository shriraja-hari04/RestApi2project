package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Car Rental Management System API")
                        .version("1.0")
                        .description("API documentation for managing users, bookings, and vehicles in the Car Rental system.")
                        .contact(new Contact()
                                .name("Raja")
                                .email("support@carrental.com")
                                .url("https://carrental.com")
                        )
                );
    }
}
