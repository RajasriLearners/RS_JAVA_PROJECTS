package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		
		User user = new User();
		user.setFirstName("gio");
		user.setMiddleName("lory");
		user.setLastName("page");
		user.setEmail("gio@gmail");
		user.setUserName("gioP");
		user.setPassword("gio123");
		user.setMobile(895498766);

		boolean registrationFlag = ferService.registration(user);
		if (registrationFlag) {
			System.out.println("Registration successfully done");
		} else {
			System.out.println("unable to Register");
		}
	}

}
