package com.ihub.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ihub.www.model.Employee;
import com.ihub.www.service.EmployeeService;
@CrossOrigin( origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeservice.getAllEmployees();
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeservice.addEmployee(employee);
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id)
	{
		return employeeservice.getEmployeeById(id);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,@RequestBody Employee employee)
	{
		return employeeservice.updateEmployeeById(id,employee);
	}
	@DeleteMapping("/employees/{id}")
	public  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
	{
		return employeeservice.deleteEmployee(id);
	}
	
	

}
