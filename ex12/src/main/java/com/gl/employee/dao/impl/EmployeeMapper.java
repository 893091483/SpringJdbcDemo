package com.gl.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gl.employee.model.Employee;

public class EmployeeMapper  implements RowMapper<Employee> {
	

		public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

			Employee employee = new Employee();
			employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
			employee.setName(resultSet.getString("EMP_NAME"));
			employee.setAge(resultSet.getInt("age"));
			employee.setSalary(resultSet.getInt("salary"));
			return employee;
		}

		
	
}
