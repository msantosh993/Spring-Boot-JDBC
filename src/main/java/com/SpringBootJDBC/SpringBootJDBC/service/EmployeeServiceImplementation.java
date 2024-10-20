package com.SpringBootJDBC.SpringBootJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringBootJDBC.SpringBootJDBC.model.Employee;
import com.SpringBootJDBC.SpringBootJDBC.repository.EmployeeJdbcRepository;
@Component
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	private EmployeeJdbcRepository employeeJdbcRepository;
	@Override
	public List<Employee> findAllEmployees() {
		return employeeJdbcRepository.findAllEmployees();
	}

	@Override
	public Employee findSpecificEmployee(Long id) {
		return employeeJdbcRepository.findSpecificEmployee(id);
	}

	@Override
	public Integer createEmployee(Employee employee) {
		return employeeJdbcRepository.createEmployee(employee);
	}

	@Override
	public Integer deleteEmployee(Long id) {
		return employeeJdbcRepository.deleteEmployee(id);
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		return employeeJdbcRepository.updateEmployee(employee);
	}

//	@Override
//	public List<Employee> truncateEmployeeTable() {
//		return employeeJdbcRepository.truncateEmployeeTable();
//	}

}
