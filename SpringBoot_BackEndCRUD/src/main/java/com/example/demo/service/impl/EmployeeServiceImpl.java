package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MyException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> GetAllEmployee() {
		
		return employeeRepo.findAll();
	}


	@Override
	public Employee getEmployeebyId(long id) {
//	 Optional<Employee> employee=employeeRepo.findById(id);
//	if(employee.isPresent()) {
//		return employee.get();
//	}else {
//		throw new MyException("Employee", "id", id);
//	}
		return employeeRepo.findById(id).orElseThrow(()->  new MyException("employee", "id", id));
	
	
	}

	@Override
	public Employee updateEmployeeById(Employee employee, long id) {
		
		Employee existingemp = employeeRepo.findById(id).orElseThrow(()->new MyException("employee", "id", id)) ;
		existingemp.setFirstName(employee.getFirstName());
		existingemp.setLastName(employee.getLastName());
		existingemp.setEmail(employee.getEmail());
		existingemp.setMobNumber(employee.getMobNumber());
		employeeRepo.save(existingemp);
		
		return existingemp;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepo.findById(id).orElseThrow(()-> new MyException("employee", "id", id));
		employeeRepo.deleteById(id);
		
	}

	
	


	
	

}
