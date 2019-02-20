package com.candidjava.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.candidjava.spring.bean.UserFER;
public interface UserFERRepository extends CrudRepository<UserFER, Integer>{
Optional<UserFER>findByUsernameAndPassword(String username,String password);

}
