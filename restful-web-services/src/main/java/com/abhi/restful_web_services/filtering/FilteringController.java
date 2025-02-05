package com.abhi.restful_web_services.filtering;

import java.util.ArrayList;
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

	@GetMapping("filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean=new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
	@GetMapping("filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList((new SomeBean("l1value1","l1value2","l1value3")),(new SomeBean("l2value1","l2value2","l2value3")));
	}
}
