package com.abhi.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Abhishek Bhosale");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("", ""));
	}
	
	
	@GetMapping(path = "person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter1() {
		return new PersonV1("Abhishek Bhosale");
	}
	
	@GetMapping(path = "person/header", params = "X-API-VERSION=2")
	public PersonV2 getFirstVersionOfPersonRequestParameter2() {
		return new PersonV2(new Name("hii", ""));
	}
	
	@GetMapping(path = "person/header",params = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader1() {
		return new PersonV1("Abhishek Bhosale");
	}
	
	
}
