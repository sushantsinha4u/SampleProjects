package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReporsitory extends MongoRepository<User,String> {

	public User findOneByEmail(String email);
	public User findOneByEmailAndPassword(String email, String password);
}
