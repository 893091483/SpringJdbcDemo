package com.gl.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.dao.impl.*;
import com.gl.employee.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO
{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee)
	{

		String sql = "INSERT INTO EMPLOYEE "
				+ "(EMPLOYEE_ID, EMP_NAME, AGE,SALARY) VALUES (?, ?, ?,?)";

		jdbcTemplate.update(sql,
				new Object[] { employee.getEmployeeId(),
						employee.getName(), employee.getAge(),
						employee.getSalary() });
		System.out.println("Employee record inserted successfully.");
	}
	
	public List <Employee> displayAll () {
		String sql = "select* from employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
		
		
	}
	public void deleteEmployee ( int id) {
		String sql = "delete from employee where EMPLOYEE_ID = ?";
		jdbcTemplate.update(sql,
				new Object[] { id });
		
		System.out.println("Deletion completed");
	}
	public void updateEmployee (Employee employee, int id) {
		String sql = "update employee set EMP_NAME = ?, AGE = ?, salary = ? where EMPLOYEE_ID = ?";
		jdbcTemplate.update(sql,employee.getName(),employee.getAge(),employee.getSalary(),id);
	}
	public List<Employee> findEmployee (int id) {
		String sql = "select * from employee where EMPLOYEE_ID = ?";
		System.out.println("Employee found!");
		return jdbcTemplate.query(sql, new Object[] { id }, new EmployeeMapper());
		
	}

	




}














