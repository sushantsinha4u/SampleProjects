package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:3333")
@RestController
@RequestMapping("/user")
public class Controller {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAll")
	public List<User> getAll (){
				
				System.out.println("Get all users...");
				 
				List<User> user = new ArrayList<>();
				user =userService.getAll();				
				System.out.println("Users List..."+user);

				return user;
				
				
	}
	
	@PostMapping("/register")
	public String register (@RequestBody User user){
		System.out.println("User..."+user);

		if(userService.register(user)){
			return "User Available";			
		}else {
			return "User Unvailable"; 
		}
	}
	
	
	@PostMapping("/login/{email}/{password}")
	public User login (@PathVariable("email") String email,@PathVariable("password") String password ){
		return userService.login(email, password);
	}
	
	
}
