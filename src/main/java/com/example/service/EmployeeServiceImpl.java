package com.example.service;

import com.example.configuration.AeroMapperConfiguration;
import com.example.entity.Employee;
import com.example.kafka.producer.KafkaEmployee;
import com.example.repository.EmployeeRepositoryImpl;
import io.micronaut.tracing.annotation.NewSpan;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    EmployeeRepositoryImpl employeeRepository;

    @Inject
    AeroMapperConfiguration aeroMapperConfiguration;

    @Inject
    KafkaEmployee kafkaEmployee;

    @NewSpan("service method")
    public String saveEmployee(Employee employee) {
        kafkaEmployee.sendEmployeeNotification("Employee " + employee.getName() + " is added successfully.");
        return employeeRepository.saveEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        kafkaEmployee.sendEmployeeNotification("List of employees : " + aeroMapperConfiguration.getMapper().scan(Employee.class));
        return employeeRepository.getAllEmployee();

    }

    public Employee getEmployeeById(Integer id) {
        kafkaEmployee.sendEmployeeNotification("Employee found by Id: " + employeeRepository.getEmployeeById(id));
        return employeeRepository.getEmployeeById(id);
    }

    public String deleteEmployeeById(Integer id) {
        kafkaEmployee.sendEmployeeNotification("Employee deleted by Id: " + id);
        return employeeRepository.deleteEmployeeById(id);
    }

    public String updateEmployeeById(Employee employee, Integer id) {
        kafkaEmployee.sendEmployeeNotification("Employee Updated of Id: " + id + "  Updated details of employee : " + employee);
        return employeeRepository.updateEmployeeById(employee, id);
    }
}
