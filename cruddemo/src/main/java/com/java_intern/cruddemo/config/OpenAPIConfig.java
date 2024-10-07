package com.java_intern.cruddemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class OpenAPIConfig {
    @Value("${openapi.url}")
    private String url;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(url);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("admin@gmail.com");
        contact.setName("admin");

        License mitLicense = new License().name("MIT License");

        Info info = new Info()
                .title("Training API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints.")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}