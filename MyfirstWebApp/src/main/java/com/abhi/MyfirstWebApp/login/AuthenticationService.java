package com.abhi.MyfirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authente(String userName,String password) {
	 boolean isValidUsername=userName.equalsIgnoreCase("abhi");
	 boolean isValidPassword=password.equalsIgnoreCase("123");
	 
		return isValidPassword & isValidUsername;
	}
}
