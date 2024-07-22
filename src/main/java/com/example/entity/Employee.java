package com.example.entity;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace = "test", set = "employee")
public class Employee {

    @AerospikeBin
    @AerospikeKey
    private Integer id;
    @AerospikeBin
    private String name;
    @AerospikeBin
    private Double salary;
    @AerospikeBin
    private String email;
    @AerospikeBin
    private String department;


    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, String email, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.department = department;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
