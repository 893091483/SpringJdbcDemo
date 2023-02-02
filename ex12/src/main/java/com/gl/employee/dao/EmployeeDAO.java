package com.gl.employee.dao;

import java.util.List;

import com.gl.employee.model.Employee;

public interface EmployeeDAO 
{
	public void insert(Employee employee);
	public void deleteEmployee ( int id);
	public void updateEmployee (Employee employee, int id);
	public List<Employee>  findEmployee ( int id);
	public List<Employee> displayAll();
	
	
	
}