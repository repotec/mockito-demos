package com.mockito.demo.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.demo.model.Employee;
import com.mockito.demo.repository.EmployeeRepository;
import com.mockito.demo.service.EmployeeService;
import com.mockito.demo.service.ValidationMap;

@ExtendWith(MockitoExtension.class)
public class UnnecessaryStubbingExceptionCase {

	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test
	@DisplayName("BDD given-when-then mock test UnnecessaryStubbingExceptionCase")
	public void givenWhenThenMock_test() {
		//given
		Employee employee = new Employee(100, "ahmed", "moahhmed");
		
		List<ValidationMap> validations = new ArrayList<>();
		validations.add(new ValidationMap("Id", "Id is null!"));
		if(employee.getName().isEmpty()) validations.add(new ValidationMap("Name", "Name is null!"));
		if(employee.getEmail().isEmpty()) validations.add(new ValidationMap("Email", "Email is null!"));
		
		//when
		Mockito.when(employeeRepository.validateEmployee(employee)).thenReturn(validations);
		
		//then
		//employeeService.updateEmployee(employee); //we missed
	}
	
	@Test
	@DisplayName("BDD given-when-then mock test UnnecessaryStubbingExceptionCase")
	public void givenWhenThenMock_test2() {
		//given
		Employee employee = new Employee(100, "ahmed", "moahhmed");
		
		List<ValidationMap> validations = new ArrayList<>();
		validations.add(new ValidationMap("Id", "Id is null!"));
		if(employee.getName().isEmpty()) validations.add(new ValidationMap("Name", "Name is null!"));
		if(employee.getEmail().isEmpty()) validations.add(new ValidationMap("Email", "Email is null!"));
		
		//when
		Mockito.when(employeeRepository.validateEmployee(employee)).thenReturn(validations);
		
		//then
		employeeService.createNewEmployee(employee); //we call wrong method
	}
}
