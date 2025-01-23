package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component 
@Repository
@Primary
public class MangoDbDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] { 1, 32, 4, 1, 454, 32 };
	}

}
