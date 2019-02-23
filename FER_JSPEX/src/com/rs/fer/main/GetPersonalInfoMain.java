package com.rs.fer.main;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FERService ferService = new FERServiceImpl();
		PersonalInfo info = ferService.getPersonalInfo(2);

		if (info != null) {
			System.out.println("userName-" + info.getUser().getUserName());

		} else {
			System.out.println("Please enter valid userId");
		}

	}

}
