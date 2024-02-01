package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.GetAllEmployee();
		
	}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getemployeebyid(@PathVariable("id") long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeebyId(id), HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> UpdateEmpBy(@PathVariable("id") long id, @RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, id), HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		
	}
	

}
