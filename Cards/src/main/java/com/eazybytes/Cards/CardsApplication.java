package com.eazybytes.Cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "AuditImpl")
@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title = "Eazy Bank Cards API",
				description = "Eazy Bank Cards Microservice",
				version = "v1.0.0",
				contact = @Contact(
						name = "Eazy Bank",
						email = "2G5ZV@example.com"
				) ,
				license = @License(
						name = "Eazy Bank",
						url = "https://www.eazybank.com/"
				)


		),
		externalDocs = @ExternalDocumentation(

				description = "Eazy Bank Documentation",
				url = "https://www.eazybank.com/"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
