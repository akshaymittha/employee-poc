package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImpl;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class EmployeeControllerTest {

    @Inject
    EmployeeServiceImpl employeeService;

    @Inject
    EmployeeController employeeController;

    @MockBean
            (EmployeeServiceImpl.class)
    EmployeeServiceImpl employeeService() {
        return mock(EmployeeServiceImpl.class);
    }

    ;

    @Test
    void saveEmployeeTestSuccess() {
        Employee employee = new Employee(1, "joe", 4000.00, "joe@gmail.com", "java");
        when(employeeService.saveEmployee(employee)).thenReturn("Employee added successfully...!");
        String result = employeeController.addEmployee(employee);
        assertEquals(result, "Employee added successfully...!");
    }

    @Test
    void getAllEmployeeTestSuccess() {
        when(employeeService.getAllEmployee()).thenReturn(Stream.of(new Employee(), new Employee()).collect(Collectors.toList()));
        Assertions.assertEquals(2, employeeController.getAllEmployee().size());
    }

    @Test
    void getEmployeeByIdTestSuccess() {
        Employee employee = new Employee(1, "joe", 4000.00, "joe@gmail.com", "java");
        when(employeeService.getEmployeeById(1)).thenReturn(employee);
        Employee result = employeeController.getEmployeeById(1);
        assertEquals(result, employeeController.getEmployeeById(employee.getId()));
    }

    @Test
    void deleteEmployeeByIdTestSuccess() {
        Employee employee = new Employee(1, "joe", 4000.00, "joe@gmail.com", "java");
        when(employeeService.deleteEmployeeById(1)).thenReturn("Employee deleted successfully...!");
        String result = employeeController.deleteEmployeeById(1);
        assertEquals(result, "Employee deleted successfully...!");
    }

    @Test
    void updateEmployeeByIdTestSuccess() {
        Employee employee = new Employee(1, "joe", 4000.00, "joe@gmail.com", "java");
        Employee newEmp = new Employee(1, "mike", 4000.00, "mike@gmail.com", "java");
        when(employeeService.updateEmployeeById(employee, 1)).thenReturn("Employee updated successfully...!");
        String result = employeeController.updateEmployee(employee, 1);
        assertEquals(result, "Employee updated successfully...!");
    }
}
