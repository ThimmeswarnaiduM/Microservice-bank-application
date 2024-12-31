package com.eazybyte.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean

	public RouteLocator eazybyteconfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/eazybyte/accounts/**")
						.filters(f -> f.rewritePath("/eazybyte/accounts/(?<segment>.*)", "/${segment}")
										.circuitBreaker(config -> config.setName("accountsCircuitBreaker").setFallbackUri("forward:/contactSupport"))
										)
						.uri("lb://ACCOUNTS"))
				.route(r -> r.path("/eazybyte/loans/**")
						.filters(f -> f.rewritePath("/eazybyte/loans/(?<segment>.*)", "/${segment}"))
						.uri("lb://LOANS"))
				.route(r -> r.path("/eazybyte/cards/**")
						.filters(f -> f.rewritePath("/eazybyte/cards/(?<segment>.*)", "/${segment}"))
						.uri("lb://CARDS")).build();

	}
}
