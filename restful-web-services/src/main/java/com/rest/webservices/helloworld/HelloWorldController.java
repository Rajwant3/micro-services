package com.rest.webservices.helloworld;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class HelloWorldController {

	
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		return "Hello RK";
	}
	
	@GetMapping(path= "/hello-world/filtered")
	public MappingJacksonValue helloWorldFiltered() {
		HelloWordBean helloWordBean = new HelloWordBean("Hello RK","Value 1","Value 2");

		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(helloWordBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("message");
		FilterProvider filters=new SimpleFilterProvider().addFilter("HomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		}
	
	@GetMapping(path= "/hello-world-bean")
	public HelloWordBean helloWorldBean() {
		return new HelloWordBean("Hello RK","Value 1","Value 2");
	}
	
	
//	@GetMapping(path= "/hello-world-bean/path-var/{name}")
//	public HelloWordBean helloWorldPathVariable(@PathVariable String name) {
//		return new HelloWordBean("Hello world : "+name);
//	}
}
