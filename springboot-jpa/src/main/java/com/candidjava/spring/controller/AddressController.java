package com.candidjava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.Address;
import com.candidjava.spring.bean.Expense;
import com.candidjava.spring.service.AddressService;

@RestController
@RequestMapping(value = { "/address" })
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping(value = "/create", headers = "Accept=application/json")
	//@RequestBody changed to @ModelAttribute.
	public ResponseEntity<Void> createAddress(@ModelAttribute Address address, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Address " + address.getAddressLine1()+address.getAddressLine2()+address.getStreet()+address.getCity()+address.getState()+address.getZip());
		addressService.createAddress(address);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/address/{addressId}").buildAndExpand(address.getAddressId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddressById(@PathVariable("addressId") int addressId) {
		System.out.println("Fetching Expense with id " + addressId);
		Address address = addressService.findById(addressId);
		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Address> getAllAddress() {
		List<Address> tasks = addressService.getAddress();
		return tasks;
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateAddress(@RequestBody Address currentAddress) {
		System.out.println("sd");
		Address address = addressService.findById(currentAddress.getAddressId());
		if (address == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		addressService.update(currentAddress, currentAddress.getAddressId());
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/{addressId}", headers = "Accept=application/json")
	public ResponseEntity<Address> deleteExpense(@PathVariable("addressId") int addressId) {
		Address address = addressService.findById(addressId);
		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		addressService.deleteAddressById(addressId);
		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value = "/{addressId}", headers = "Accept=application/json")
	public ResponseEntity<Address> updateAddressPartially(@PathVariable("addressId") int addressId,
			@RequestBody Address currentAddress) {
		Address address = addressService.findById(addressId);
		if (address == null) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		Address ads = addressService.updatePartially(currentAddress, addressId);
		return new ResponseEntity<Address>(ads, HttpStatus.OK);
	}
}
