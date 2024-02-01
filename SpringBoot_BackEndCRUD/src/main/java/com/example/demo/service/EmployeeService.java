package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> GetAllEmployee( );
	Employee getEmployeebyId(long id);
	Employee updateEmployeeById(Employee employee, long id);
	void deleteEmployee(long id);
}

