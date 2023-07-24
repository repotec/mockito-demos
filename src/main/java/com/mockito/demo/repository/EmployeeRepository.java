package com.mockito.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.mockito.demo.model.Employee;
import com.mockito.demo.service.ValidationMap;

public class EmployeeRepository {

	public void update(Employee employee){

	}
	public boolean save(Employee employee) {
		if(employee == null) {
			return false;
		}
		
		return true;
	}
	
	public List<ValidationMap> validateEmployee(Employee employee) {
		List<ValidationMap> validations = new ArrayList<>();
		
		if(employee.getId() == null) {
			validations.add(new ValidationMap("Id", "Id is null!"));
		}
		
		if(employee.getName().isEmpty()) {
			validations.add(new ValidationMap("Name", "Id is null!"));
		}
		
		if(employee.getEmail().isEmpty()) {
			validations.add(new ValidationMap("Email", "Id is null!"));
		}
		
		return validations;
	}
}
