package com.mockito.demo.service;

import java.util.List;

import com.mockito.demo.model.Employee;
import com.mockito.demo.repository.EmployeeRepository;

public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
	    this.employeeRepository = employeeRepository;
	}
	
	public boolean createNewEmployee(Employee employee) {
		if(employee.getEmail() == null) {
			throw new IllegalArgumentException("Email is mandatory!");
		}
	    return employeeRepository.save(employee);
	}
	
	public List<ValidationMap> updateEmployee(Employee employee) {		
		return employeeRepository.validateEmployee(employee);
	}

	public void update (Employee employee) {
		//nothing
	}
}
