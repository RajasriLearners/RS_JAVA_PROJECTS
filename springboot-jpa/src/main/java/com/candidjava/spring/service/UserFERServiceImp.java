package com.candidjava.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.bean.UserFER;
import com.candidjava.spring.repository.UserFERRepository;

@Service
@Transactional
public class UserFERServiceImp implements UserFERService {
	@Autowired
	UserFERRepository userFERRepository;

	@Override
	public void createUser(UserFER userfer) {
		userFERRepository.save(userfer);
		
	}

	@Override
	public List<UserFER> getUser() {
		return (List<UserFER>) userFERRepository.findAll();
	}

	@Override
	public UserFER findById(int userId) {
		return userFERRepository.findOne(userId);
	}

	@Override
	public UserFER update(UserFER user, int i) {
		return userFERRepository.save(user);
	}

	@Override
	public void deleteUserById(int userId) {
		userFERRepository.delete(userId);
		
	}

	@Override
	public UserFER updatePartially(UserFER user, int userId) {
		UserFER usr = findById(userId);
		usr.setMobile(user.getMobile());
		return userFERRepository.save(usr);
	}

	@Override
	public boolean login(String username, String password) {
		Optional<UserFER>userFEROptional=userFERRepository.findByUsernameAndPassword(username, password);
		return userFEROptional!=null &&userFEROptional.isPresent() ;
	}


}
