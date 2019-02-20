package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.UserFER;

public interface UserFERService {
	public void createUser(UserFER user);
	public List<UserFER> getUser();
	public UserFER findById(int userId);
	public UserFER update(UserFER user, int i);
	public void deleteUserById(int userId);
	public UserFER updatePartially(UserFER user, int userId);
	boolean login(String username ,String password);
}
