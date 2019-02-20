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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.bean.UserFER;
import com.candidjava.spring.service.UserFERService;

@RestController
@RequestMapping(value={"/userfer"})
public class UserFERController {
	@Autowired
	UserFERService userferService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserFER> getUserById(@PathVariable("id") int userId) {
		System.out.println("Fetching User with id " + userId);
		UserFER userfer = userferService.findById(userId);
		if (userfer == null) {
			return new ResponseEntity<UserFER>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserFER>(userfer, HttpStatus.OK);
	}
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody UserFER userfer, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+userfer.getFirstName()+userfer.getMiddleName()+userfer.getLastName()+userfer.getEmail()+userfer.getUsername()+userfer.getPassword()+userfer.getMobile());
	     userferService.createUser(userfer);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/userfer/{userId}").buildAndExpand(userfer.getUserId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	 
	 @GetMapping(value = "/get", headers = "Accept=application/json")
	 public List<UserFER> getAllUser() {
		List<UserFER> tasks = userferService.getUser();
		return tasks;
	}
	 
	 @PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody UserFER currentUser)
	{
		System.out.println("sd");
		UserFER user = userferService.findById(currentUser.getUserId());
		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		userferService.update(currentUser, currentUser.getUserId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	 @DeleteMapping(value = "/{id}", headers = "Accept=application/json")

	public ResponseEntity<UserFER> deleteUser(@PathVariable("id") int userId) {
		UserFER user = userferService.findById(userId);
		if (user == null) {
			return new ResponseEntity<UserFER>(HttpStatus.NOT_FOUND);
		}
		userferService.deleteUserById(userId);
		return new ResponseEntity<UserFER>(HttpStatus.NO_CONTENT);
	}
	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<UserFER> updateUserPartially(@PathVariable("id") int userId, @RequestBody UserFER currentUser) {
		UserFER user = userferService.findById(userId);
		if (user == null) {
			return new ResponseEntity<UserFER>(HttpStatus.NOT_FOUND);
		}
		UserFER usr = userferService.updatePartially(currentUser, userId);
		return new ResponseEntity<UserFER>(usr, HttpStatus.OK);
	}
	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("login " + username);
		Boolean isValid = userferService.login(username, password);

		if (!isValid) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(isValid, HttpStatus.OK);
	}

}
