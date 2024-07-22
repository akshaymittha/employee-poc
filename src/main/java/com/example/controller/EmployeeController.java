package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeServiceImpl;
import io.jaegertracing.internal.JaegerTracer;
import io.micronaut.http.annotation.*;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.opentracing.Span;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


@Controller("/employee")
@Tag(name = "employee-api")
public class EmployeeController {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);


    @Inject
    EmployeeServiceImpl employeeService;
    @Inject
    private JaegerTracer tracer;

    public EmployeeController(JaegerTracer tracer) {
        try (JaegerTracer jaegerTracer = this.tracer = tracer) {
        }
    }

//    @Post("/add")
//    public String addEmployee(@Body Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }

    @Post("/add")
    @NewSpan
    public String addEmployee(@Body Employee employee) {
        Span span = tracer.activeSpan();
        span.setTag("employee name", employee.getName());
        LOGGER.info("Employee " + employee.getName() + " has been added");
        return employeeService.saveEmployee(employee);
    }

    @Get("/show")
    public List<Employee> getAllEmployee() {
//        LOGGER.info("Employees find");
        return employeeService.getAllEmployee();
    }

    @Get("/{id}")
    @ContinueSpan
    public Employee getEmployeeById(@SpanTag("employee.id") @PathVariable Integer id) {
        LOGGER.info("Employee found by id: " + id);
        return employeeService.getEmployeeById(id);
    }


    @Delete("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        LOGGER.info("Employee deleted by id: " + id);
        return employeeService.deleteEmployeeById(id);
    }

    @Put("/update/{id}")
    public String updateEmployee(@Body Employee employee, @PathVariable Integer id) {
        LOGGER.info("Employee updated by id: " + id + "  Updated details : " + employee);
        return employeeService.updateEmployeeById(employee, id);
    }
}
