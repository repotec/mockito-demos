
package com.mockito.demo.mock.annotations;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.demo.model.Employee;
import com.mockito.demo.repository.EmployeeRepository;
import com.mockito.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class InjectMocksAnnotationTest {
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testWithWhenAndReturn() {
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(true);
		
		Employee employee = new Employee(1L, "test", "test");
		employeeService.createNewEmployee(employee);
		
		Mockito.verify(employeeRepository, Mockito.times(0)).save(Mockito.any(Employee.class));
	}
}
