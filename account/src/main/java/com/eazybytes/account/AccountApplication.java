package com.eazybytes.account;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing(auditorAwareRef = "AuditImp")
@OpenAPIDefinition(
		info = @Info(
				title = "Account Microservice Rest API Documentation",
				description = "EazyAccount Microservice Rest API Documentation",
				version = "v1.0.0",
				contact = @Contact(
						name = "Thimmeswaranaidu",
						email = "thimmeswaranaidu@modupalli.com",
						url = "https://thimmeswaranaidu.com"
				),
				license = @License(
						name = "Eazy-Bites",
						url = "https://thimmeswaranaidu.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Eazy-Bites",
				url = "https://thimmeswaranaidu.com"
		)
)
@EnableFeignClients
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
