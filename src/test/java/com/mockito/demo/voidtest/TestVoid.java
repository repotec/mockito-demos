package com.mockito.demo.voidtest;

import com.mockito.demo.model.Employee;
import com.mockito.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestVoid {

    @Mock
    EmployeeService employeeService;

    @Test
    public void whenCalledDoNothing_thenVerified() {
        Mockito.doNothing().when(employeeService).update(Mockito.isA(Employee.class));
        employeeService.update(new Employee(1, "test", "test"));
        Mockito.verify(employeeService, Mockito.times(1)).update(Mockito.isA(Employee.class));
    }

    @Test
    public void whenCalledDoAnswer_thenVerified() {
        Employee emp = new Employee(1, "test", "test");


        Mockito.doAnswer(invocation -> {
            Object empArg = invocation.getArgument(0);

            assertEquals(emp, empArg);
            return null;
        }).when(employeeService).update(Mockito.isA(Employee.class));

        employeeService.update(emp);
    }

    @Test
    public void whenCalledDoPartialMock_thenVerified() {
        Employee emp = new Employee(1, "real", "real");

        Mockito.doCallRealMethod().when(employeeService).update(Mockito.isA(Employee.class));

        employeeService.update(emp);

        Mockito.verify(employeeService, Mockito.times(1)).update(Mockito.isA(Employee.class));
    }
}