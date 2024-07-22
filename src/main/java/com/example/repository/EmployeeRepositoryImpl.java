package com.example.repository;

import com.example.configuration.AeroMapperConfiguration;
import com.example.entity.Employee;
import jakarta.inject.Inject;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Inject
    AeroMapperConfiguration aeroMapperConfiguration;

    @Override
    public String saveEmployee(Employee employee) {
//        EmailService.sendEmail(new EmployeeEmail("Employee alert", "Employee added successfully...!", employee.getEmail()));
        aeroMapperConfiguration.getMapper().save(employee);
        return "Employee added successfully...!";
    }

    @Override
    public List<Employee> getAllEmployee() {
        return aeroMapperConfiguration.getMapper().scan(Employee.class);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return aeroMapperConfiguration.getMapper().read(Employee.class, id);
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        aeroMapperConfiguration.getMapper().delete(Employee.class, id);
        return "Employee deleted successfully...!";
    }

    @Override
    public String updateEmployeeById(Employee employee, Integer id) {
        Employee emp = aeroMapperConfiguration.getMapper().read(Employee.class, id);
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        aeroMapperConfiguration.getMapper().save(emp);
        return "Employee updated successfully...!";
    }
}
