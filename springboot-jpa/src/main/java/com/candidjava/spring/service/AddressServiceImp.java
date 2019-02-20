package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Address;
import com.candidjava.spring.bean.Expense;
import com.candidjava.spring.repository.AddressRepository;


@Service
@Transactional
public class AddressServiceImp implements AddressService{

	@Autowired
	AddressRepository addressRepository;

	@Override
	public void createAddress(Address address) {
		addressRepository.save(address);
		
	}

	@Override
	public List<Address> getAddress() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public Address findById(int addressId) {
		return addressRepository.findOne(addressId);
	}

	@Override
	public Address update(Address address, int addressId) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddressById(int addressId) {
		addressRepository.delete(addressId);
	}

	@Override
	public Address updatePartially(Address address, int addressId) {
		Address ads = findById(addressId);
		ads.setZip(address.getZip());
		return addressRepository.save(ads);
	}
		
	

}
