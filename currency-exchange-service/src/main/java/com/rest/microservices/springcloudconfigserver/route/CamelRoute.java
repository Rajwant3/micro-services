//package com.rest.microservices.springcloudconfigserver.route;
//
//import org.apache.camel.Exchange;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CamelRoute extends RouteBuilder{
//
//	@Autowired
//	private Environment env;
//	
//	
//	@Override
//	public void configure() throws Exception {
//		restConfiguration().component("servlet").port(env.getProperty("server.port","8080"))
//		.contextPath("api").apiContextPath("/camel");
//		
//		
//		from("rest:camel:currency-exchange/from/{from}/to/{to}")
//		.routeId("currency-exchange")
//		.setHeader(Exchange.HTTP_METHOD,constant("GET"))
//		.removeHeader("CamelHttp*")
//.to("")
//	}
//
//}
