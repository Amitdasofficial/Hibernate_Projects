package org.jsp.employeeapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController 
{
    static Scanner s=new Scanner(System.in);
    static EmployeeDao dao= new EmployeeDao();
    public static void main(String[] args) 
    {
	   System.out.println("1.Save Employee");
	   System.out.println("2.Update Employee");
	   System.out.println("3.Find Employee By id");
	   System.out.println("4.Verify Employee By Phone and Password");
	   System.out.println("5.Verify Employee By Id and Password");
	   System.out.println("6.Delete Employee by Id");
	   System.out.println("7.Find Employee By Designation");
	   
    	int choice=s.nextInt();
    	switch(choice)
    	{
    	case 1:
    	{
    		save();
    		break;
    	}
    	case 2:
    	{
    		update();
    		break;
    	}
    	case 3:
    	{
    		findById();
    		break;
    	}
    	case 4:
    	{
    		verifyByPhone();
    		break;
    	}
    	
    	case 5:
    	{
    		verifyById();
    		break;
    	}
    	case 6:
    	{
    		delete();
    		break;
    	}
    	case 7:
    	{
    		findByDesg();
    		break;
    	}
    	default:
    	{
    		System.err.println("Invalid Choice Please input valid choice");
    	}
    	
    	}
    	
	}
	
    
    public static void save()
    {
    	System.out.println("Enter the Employee name,desg,salary,phone and password to register");
    	Employee e=new Employee();
    	e.setName(s.next());
    	e.setDesg(s.next());
    	e.setSalary(s.nextDouble());
    	e.setPhone(s.nextLong());
    	e.setPassword(s.next());
    	e=dao.saveEmployee(e);
    	System.out.println("Employee Saved with Id:"+e.getId());
    }
    
	public static void update()
	{
		System.out.println("Enter Your Id to Update");
		int id=s.nextInt();
		System.out.println("Enter the Employee name,desg,salary,phoneno, password to update");
		Employee e=new Employee();
		e.setId(id);
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setPassword(s.next());
		e=dao.updateEmployee(e);
		System.out.println("Employee Update with Id:"+e.getId());
	
		}
	public static void verifyByPhone()
	{
		System.out.println("Enter Your Phone and Password to Verify");
		long phone=s.nextLong();
		String password=s.next();
		Employee e=dao.verifyEmployee(phone, password);
		if(e!=null)
		{
			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Designation:"+e.getDesg());
			System.out.println("Salary:"+e.getSalary());
			System.out.println("Phone Number:"+e.getPhone());
		}
		else
		{
			System.err.println("Invalid Phone number or Password");
		}
	}
	
	
	public static void verifyById() {
		System.out.println("Enter your Id and password to verify");
		int id = s.nextInt();
		String password = s.next();
		Employee e = dao.verifyEmployee(id, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designtaion:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("invalid  Id or password");
		}
	}
	
	
	public static void delete() {
		System.out.println("Enter Employee Id to delete");
		int id = s.nextInt();
		boolean deleted = dao.deleteEmployee(id);
		if (deleted) {
			System.out.println("Employee deleted");
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
	
	
	public static void findById() {
		System.out.println("Enter the Employee id to display details");
		int id = s.nextInt();
		Employee e = dao.findById(id);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designtaion:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
	
	
	public static void findByDesg() {
		System.out.println("Enter the Employee Desg to display details");
		String desg = s.next();
		List<Employee> emps = dao.findEmployeeByDesg(desg);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee Name:" + e.getName());
				System.out.println("Designtaion:" + e.getDesg());
				System.out.println("Salary:" + e.getSalary());
				System.out.println("Phone Number:" + e.getPhone());
			}
		} else {
			System.err.println("No employee found with entered designtaion");
		}
	}


	
}
