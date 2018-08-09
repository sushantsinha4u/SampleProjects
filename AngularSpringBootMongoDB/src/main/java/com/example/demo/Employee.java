package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
 
	private String id;
 
	private String name;
	private int age;
	private boolean active;
 


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Employee() {
	}
 
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
 
	
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getName() {
		return this.name;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	public int getAge() {
		return this.age;
	}
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
 
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", active=" + active + "]";
	}
}