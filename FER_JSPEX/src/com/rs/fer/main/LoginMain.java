package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		int userId = ferService.login("devi12", "dev");
		if (userId > 0) {
			System.out.println("Login successfully");

		} else {
			System.out.println("Login failed");
		}

	}

}
