package com.abhi.restful_web_services.versioning;


public class PersonV2 {
	
	private Name name;


	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}
}
