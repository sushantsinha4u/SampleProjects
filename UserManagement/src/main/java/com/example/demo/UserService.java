package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
	private UserReporsitory userRepository;
	
	public boolean register(User u){
		System.out.println("email..."+u.getEmail());

		if(userRepository.findOneByEmail(u.getEmail())!=null){
			return false;
		}else{
			System.out.println("u..."+u);

			userRepository.save(u);
			return true;
		}	
	}
	
	
	public User login (String email , String password){
		return userRepository.findOneByEmailAndPassword(email, password);
		
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
		
	}
	
}
