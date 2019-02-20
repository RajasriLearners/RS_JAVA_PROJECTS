package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.Address;

public interface AddressService {

	public void createAddress(Address address);
	public List<Address> getAddress();
	public Address findById(int addressId);
	public Address update(Address address, int addressId);
	public void deleteAddressById(int addressId);
	public Address updatePartially(Address address, int addressId);
}
