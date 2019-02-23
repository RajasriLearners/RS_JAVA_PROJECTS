package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		boolean resetPasswordFlag = ferService.resetPassword(1, "devi123", "devi1234");

		if (resetPasswordFlag) {
			System.out.println("Password resetting is done successfully");

		} else {
			System.out.println("Unable to do resetting of password");
		}

	}

}
