package com.SpringBootJDBC.SpringBootJDBC.service;

import java.util.List;

import com.SpringBootJDBC.SpringBootJDBC.model.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployees();
	Employee findSpecificEmployee(Long id);
	Integer createEmployee(Employee employee);
	Integer deleteEmployee(Long id);
	Integer updateEmployee(Employee employee);
//	List<Employee> truncateEmployeeTable();
}
