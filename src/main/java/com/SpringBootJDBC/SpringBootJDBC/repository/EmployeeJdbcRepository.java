package com.SpringBootJDBC.SpringBootJDBC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringBootJDBC.SpringBootJDBC.Exceptions.EmployeeNotFoundException;
import com.SpringBootJDBC.SpringBootJDBC.model.Employee;

@Repository
public class EmployeeJdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String findAllEmployeesQuery = "SELECT * FROM EMPLOYEE";
	private String findSpecificEmployeeQuery = "SELECT * FROM EMPLOYEE WHERE ID=?";
	private String createEmployeeQuery = "INSERT INTO EMPLOYEE(ID,FIRSTNAME,LASTNAME,MOBILENUMBER,EMAILID,AGE) VALUES(?,?,?,?,?,?)";
	private String deleteEmployeeQuery = "DELETE FROM EMPLOYEE WHERE ID=?";
	private String updateEmployeeQuery = "UPDATE EMPLOYEE SET FIRSTNAME=?,LASTNAME=?,MOBILENUMBER=?,EMAILID=?,AGE=? WHERE ID=?";

//	private String truncateEmployeeTableQuery="TRUNCATE TABLE EMPLOYEE";
	public List<Employee> findAllEmployees() {
		return jdbcTemplate.query(findAllEmployeesQuery, new BeanPropertyRowMapper<>(Employee.class));
	}

	public Integer createEmployee(Employee employee) {
		return jdbcTemplate.update(createEmployeeQuery, employee.getId(), employee.getFirstName(),
				employee.getLastName(), employee.getMobileNumber(), employee.getEmailId(), employee.getAge());
	}

	public Employee findSpecificEmployee(Long id) {
		Employee employee;
		try {
			employee = jdbcTemplate.queryForObject(findSpecificEmployeeQuery,
					new BeanPropertyRowMapper<>(Employee.class), id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("ID = " + id + " Not Found in the DataBase");
		}
		return employee;
	}

	public Integer updateEmployee(Employee employee) {
		return jdbcTemplate.update(updateEmployeeQuery, employee.getFirstName(), employee.getLastName(),
				employee.getMobileNumber(), employee.getEmailId(), employee.getAge(), employee.getId());
	}

	public Integer deleteEmployee(Long id) {
		return jdbcTemplate.update(deleteEmployeeQuery, id);
	}
//	public List<Employee> truncateEmployeeTable()
//	{
//		return jdbcTemplate.query(truncateEmployeeTableQuery,new BeanPropertyRowMapper<>(Employee.class));
//	}
}
