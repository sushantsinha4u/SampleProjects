package com.example.demo;


import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

@CrossOrigin(origins = "http://localhost:4401")
@RestController
@RequestMapping("/api")
public class EmployeeController {
 
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	 @Autowired
	    MongoTemplate mongoTemplate;
	 
 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Get all Employees...");
 
		List<Employee> employees = new ArrayList<>();
		employees =employeeRepository.findAll();
		
		System.out.println("Employees List..."+employees);

		return employees;
	}
 
	@PostMapping("/employees/create")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		System.out.println("Create Employee: " + employee.getName() + "...");
 
		employee.setId(employee.getId());
		employee.setActive(false);
		Employee _employee = employeeRepository.save(employee);
		return new ResponseEntity<>(_employee, HttpStatus.OK);
	}
 
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
		System.out.println("Update Employee with ID = " + id + "...");
 
		Employee employeeData = findOne(id);
		if (employeeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		employeeData.setName(employee.getName());
		employeeData.setAge(employee.getAge());
		employeeData.setActive(employee.isActive());
		Employee updatedemployee = employeeRepository.save(employeeData);
		return new ResponseEntity<>(updatedemployee, HttpStatus.OK);
	}
 
	
	 public Employee findOne(String id) {
	    	System.out.println("id----"+id);
			return  mongoTemplate.findOne
					(Query.query(
							new Criteria().orOperator
							(Criteria.where("id").is(id))),Employee.class);
	         }
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
		System.out.println("Delete Employee with ID = " + id + "...");
 
		employeeRepository.deleteById(id);
		return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
	}
 
	@DeleteMapping("/employees/delete")
	public ResponseEntity<String> deleteAllEmployees() {
		System.out.println("Delete All Employees...");
 
		employeeRepository.deleteAll();
		return new ResponseEntity<>("All employees have been deleted!", HttpStatus.OK);
	}
}