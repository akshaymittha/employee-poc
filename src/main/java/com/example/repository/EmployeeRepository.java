package com.example.repository;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    public String saveEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(Integer id);

    public String deleteEmployeeById(Integer id);

    public String updateEmployeeById(Employee employee, Integer id);
}
