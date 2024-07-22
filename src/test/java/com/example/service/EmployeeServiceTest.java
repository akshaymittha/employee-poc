package com.example.service;

import com.example.entity.Employee;
import com.example.kafka.producer.KafkaProducer;
import com.example.repository.EmployeeRepositoryImpl;
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
public class EmployeeServiceTest {

    @Inject
    EmployeeRepositoryImpl employeeRepository;

    @Inject
    EmployeeServiceImpl employeeService;

    @MockBean(EmployeeRepositoryImpl.class)
    EmployeeRepositoryImpl employeeRepository() {

        return mock(EmployeeRepositoryImpl.class);
    };

    @MockBean(KafkaProducer.class)
    KafkaProducer kafkaProducer() {
        return mock(KafkaProducer.class);
    };


    @Test
    void saveEmployeeTestSuccess() {
        Employee employee = new Employee(1, "Akshay", 2000.00, "akshay@gmail.com", "devops");
        when(employeeRepository.saveEmployee(employee)).thenReturn("Employee added successfully...!");
        String result = employeeService.saveEmployee(employee);
        assertEquals(result, "Employee added successfully...!");
    }

    @Test
    void getEmployeesSuccess() {
        when(employeeRepository.getAllEmployee()).thenReturn(Stream.of(new Employee(),
                new Employee(),
                new Employee()).collect(Collectors.toList()));

        Assertions.assertEquals(3, employeeService.getAllEmployee().size());
    }


    @Test
    void getEmployeeByIdTestSuccess() {
        Employee employee = new Employee(2, "anna", 30000.00, "anana@gmail.com", "devops");
        employee.setId(2);
        when(employeeRepository.getEmployeeById(2)).thenReturn(employee);
        Employee result = employeeService.getEmployeeById(2);
        assertEquals(result, employeeService.getEmployeeById(employee.getId()));
    }

    @Test
    void deleteEmployeeByIdTestSuccess() {
        Employee employee = new Employee(1, "Akshay", 2000.00, "akshay@gmail.com", "devops");
        when(employeeRepository.deleteEmployeeById(1)).thenReturn("Employee deleted successfully...!");
        String result = employeeService.deleteEmployeeById(1);
        assertEquals(result, "Employee deleted successfully...!");
    }

    @Test
    void updateEmployeeByIdTestSuccess() {
        Employee employee = new Employee(1, "Akshay", 2000.00, "akshay@gmail.com", "devops");
        Employee newEmp = new Employee(1, "anna", 2000.00, "anna@gmail.com", "devops");
        when(employeeRepository.updateEmployeeById(employee, 1)).thenReturn("Employee updated successfully...!");
        String result = employeeService.updateEmployeeById(employee, 1);
        assertEquals(result, "Employee updated successfully...!");

    }
}
