package com.eazybytes.Loans;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice",
				version = "1.0.0",
				description = "Loans Microservice API",
		contact=@Contact(
				name="Thimmeswaranaidu",
				email="GmGj9@example.com"
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
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
