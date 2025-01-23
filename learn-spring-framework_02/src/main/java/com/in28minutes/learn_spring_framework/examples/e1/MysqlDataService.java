package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Qualifier("MysqlDataServiceQualifier")
public class MysqlDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] { 32, 432, 13, 55, 2, 1000 };
	}

}
