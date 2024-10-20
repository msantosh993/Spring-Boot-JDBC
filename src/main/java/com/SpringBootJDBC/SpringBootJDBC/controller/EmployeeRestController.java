package com.SpringBootJDBC.SpringBootJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootJDBC.SpringBootJDBC.model.Employee;
import com.SpringBootJDBC.SpringBootJDBC.service.EmployeeServiceImplementation;

import jakarta.validation.Valid;


@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeServiceImplementation employeeServiceImplemnentation;
	@GetMapping("findAllEmployees")
	public List<Employee> findAllEmployees()
	{
		return employeeServiceImplemnentation.findAllEmployees();
	}
	@PostMapping("createEmployee")
	public Integer createEmployee(@Valid @RequestBody Employee employee)
	{
		return employeeServiceImplemnentation.createEmployee(employee);
	}
	@GetMapping("findSpecificEmployee/{id}")
	public Employee findSpecificEmployee(@PathVariable Long id)
	{
		return employeeServiceImplemnentation.findSpecificEmployee(id);
	}
	//or
//	@PostMapping("findSpecificEmployee")
//	public Employee findSpecificEmployee(@PathVariable Employee employee)
//	{
//		return employeeServiceImplemnentation.findSpecificEmployee(employee.getId());
//	}
	@PutMapping("updateEmployee")
	public Integer updateEmployee(@RequestBody Employee employee)
	{
		return employeeServiceImplemnentation.updateEmployee(employee);
	}
	@PutMapping("deleteEmployee/{id}")
	public Integer deleteEmployee(@PathVariable Long id)
	{
		return employeeServiceImplemnentation.deleteEmployee(id);
	}
//	@GetMapping("truncateEmployeeTable")
//	public List<Employee> truncateEmployeeTable()
//	{
//		return employeeServiceImplemnentation.truncateEmployeeTable();
//	}
}
