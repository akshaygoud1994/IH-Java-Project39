package com.ihub.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ihub.www.exception.ResourceNotFoundException;
import com.ihub.www.model.Employee;
import com.ihub.www.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRipository;

	public List<Employee> getAllEmployees() {
		
		return employeeRipository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		
		return employeeRipository.save(employee);
	}

	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRipository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
	}

	public ResponseEntity<Employee> updateEmployeeById(long id, Employee employee) 
	{ 
		//System.out.println(employee);
		Employee oldEmp=employeeRipository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
		        oldEmp.setFirstName(employee.getFirstName());
		        oldEmp.setLastName(employee.getLastName());
		        oldEmp.setEmail(employee.getEmail());
		      Employee updateEmp=employeeRipository.save(oldEmp);
		return  ResponseEntity.ok(updateEmp);
	}

	public ResponseEntity<HttpStatus> deleteEmployee(long id) {
		System.out.println(id);
		  Employee employee=employeeRipository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Does not Exit"));
		  employeeRipository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}