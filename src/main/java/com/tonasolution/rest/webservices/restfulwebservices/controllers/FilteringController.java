package com.tonasolution.rest.webservices.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retreiveSomeBean() {
		SomeBean  someBean = new SomeBean("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("value1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters );
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retreiveListOfSomeBean() {
		List<SomeBean> someBeans =  Arrays.asList(
											new SomeBean("value1", "value2", "value3"),
											new SomeBean("value1", "value2", "value3"),
											new SomeBean("value1", "value2", "value3")
									);
		
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("value1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
		mapping.setFilters(filters );
		
		return mapping;
	}
}