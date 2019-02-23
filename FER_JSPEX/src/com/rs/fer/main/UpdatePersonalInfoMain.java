package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalInfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstName("Narasimaha");
		user.setMiddleName("Raju");
		user.setLastName("Vegesna");
		user.setEmail("Narasimaha@gmail.com");
		user.setUserName("Narasimha@gmail.com");
		user.setPassword("narasimha123");
		user.setMobile(78930309);
		user.setUserId(5);

		Address address = new Address();
		address.setAddressId(3);
		address.setAddressLine1("Madhuranagar");
		address.setAddressLine2("sanathnagar");
		address.setStreet("Kphb");
		address.setCity("Hyderabad");
		address.setState("telangana");
		address.setZip(7561);
		address.setUserId(user.getUserId());

		boolean personalInfoFlag = ferService.updatePersonalInfo(user, address);

		if (personalInfoFlag) {
			System.out.println("Personal info updatedsuccessfully");
		} else {
			System.out.println("Unable to upadate");
		}

	}
}
