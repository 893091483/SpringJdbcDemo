package com.gl.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;
import java.util.*;
public class App
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeDAO employeeDAO = (EmployeeDAO) context
				.getBean("employeeDAO");
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		
			
		do {
			System.out.println("1-Insert");
			System.out.println("2-Update");
			System.out.println("3-Delete by ID");
			System.out.println("4-Display all");
			System.out.println("5-exit");
			System.out.println("enter your choice:");
			choice=sc.nextInt();
			
			
				
				switch (choice) {
				case 1:
					System.out.println("Enter employee Id");
					int id=sc.nextInt();
					System.out.println("Enter employee name");
					String name=sc.next();
					System.out.println("Enter employee age");
					int age=sc.nextInt();
					System.out.println("Enter employeesalary");
					int salary=sc.nextInt();
					Employee employee = new Employee(id, name, age, salary);
					employeeDAO.insert(employee);
				
					break;
				case 2:
					System.out.println("Enter employee Id");
					 id=sc.nextInt();
					System.out.println("Enter employee name");
					 name=sc.next();
					System.out.println("Enter employee age");
					 age=sc.nextInt();
					System.out.println("Enter employee salary");
					 salary=sc.nextInt();
					 employee=new Employee(id, name, age, salary);
					employeeDAO.updateEmployee(employee,id);
					break;
				case 3:
					System.out.println("Enter employee id for delete");
					id=sc.nextInt();
					employeeDAO.deleteEmployee(id);
					break;
				case 4:
					
					for(Employee e:employeeDAO.displayAll()) {
						System.out.println(e.toString());
					}
					break;
				}
		}while(choice != 5);
		
		

		
		
	}
}
	

