package com.rest.microservices.namingserver;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewaysConfiguration {


	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		 Function<PredicateSpec, Buildable<Route>> routeFunction
		 =p->p.path("/get")
		 .filters(f->f.addRequestHeader("MyHeader", "RkURI").addRequestParameter("RkPARAM", "RKValue"))
		 .uri("http://httpbin.org:80");

		return builder.routes()
				.route(routeFunction)
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion-service"))
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion-service"))
				.build();
	}
}
