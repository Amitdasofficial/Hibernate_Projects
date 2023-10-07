package org.jsp.deptemp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.deptemp.dao.DepartmentDao;
import org.jsp.deptemp.dao.EmployeeDao;
import org.jsp.deptemp.dto.Department;
import org.jsp.deptemp.dto.Employee;

public class Dept_Emp_Controller {

	static Scanner s = new Scanner(System.in);
	static DepartmentDao deptDao = new DepartmentDao();
	static EmployeeDao empDao = new EmployeeDao();

	public static void main(String[] args) {
		System.out.println("1.Save Department.");
		System.out.println("2.update Department.");
		System.out.println("3.Save Employee");
		System.out.println("4.Update Employee");
		System.out.println("5.Find Employee By Department Id");
		System.out.println("6.Find Employee By Department name");
		System.out.println("7.Verify Employee By Id and Password");
		System.out.println("8.Verify Employee By phone and Password");
		System.out.println("9.Verify Employee By email and Password");
		System.out.println("10.Find Department By Id");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			saveDept();
			break;
		}
		case 2: {
			updateDept();
			break;
		}
		case 3: {
			saveEmployee();
			break;
		}
		case 4: {
			updateEmp();
			break;
		}
		case 5:{
			findEmpsByDeptId();
			break;
		}
		case 6:{
			findEmpsByDeptName();
			break;
		}
		case 7:{
			verifyEmpById();
			break;
		}
		case 8:
		{
			verifyEmpByPhone();
			break;
		}
		case 9:
		{
			verifyEmpByEmail();
			break;
		}
		case 10:
		{
			findDeptById();
			break;
		}
		}
	}

	public static void saveDept() {
		System.out.println("Enter the name and location to save department");
		Department d = new Department();
		d.setName(s.next());
		d.setLocation(s.next());
		d = deptDao.saveDepartment(d);
		System.out.println("Department saved with Id:" + d.getId());
	}

	public static void updateDept() {
		System.out.println("Enter the Department Id to Update");
		int id = s.nextInt();
		System.out.println("Enter the name and Location to  save Department");
		Department d = new Department();
		d.setId(id);
		d.setName(s.next());
		d.setLocation(s.next());
		d = deptDao.updateDepartment(d);
		System.out.println("Department Updated");

	}

	public static void saveEmployee() {
		System.out.println("Enter the department id to add Employee");
		int dept_id = s.nextInt();
		System.out.println("Enter the  name,desg,salary,phone,email and password to save the employee");
		Employee e = new Employee();
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setPassword(s.next());
		e = empDao.saveEmployee(e, dept_id);
		if (e != null) {
			System.out.println("Employee save With Id:" + e.getId());
		} else {
			System.err.println("Invalid Department Id");
		}
	}

	public static void updateEmp() {
		System.out.println("Enter the department Id to Update Employee");
		int dept_id = s.nextInt();
		System.out.println("Enter the id, name,desg, salary, phone,email, passwors to save Employee");
		Employee e = new Employee();
		e.setId(s.nextInt());
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setPassword(s.next());
		e = empDao.updateEmployee(e, dept_id);

		if (e != null) {
			System.out.println("Employee update With Id:" + e.getId());
		} else {
			System.err.println("Invalid Department Id");
		}
	}
	
	public static void findEmpsByDeptId() 
	{
		System.out.println("Enter the DeptId to find Employee");
		int dept_id=s.nextInt();
		List<Employee> emps= empDao.findEmpsByDeptId(dept_id);
		
		if(emps.size()>0)
		{
			for(Employee e:emps)
			{
				System.out.println("Employee Id: "+e.getId());
				System.out.println("Employee name: "+e.getName());
				System.out.println("Designation: "+e.getDesg());
				System.out.println("Phone Number: "+e.getPhone());
				System.out.println("Email Id: "+e.getEmail());
				System.out.println("----------------");
			}
		}
		else {
			System.err.println("Invalid Department Id");
		}
		
	}
	
	public static void findEmpsByDeptName() 
	{
		System.out.println("Enter the Department Name to find Employee");
		String name=s.next();
		List<Employee> emps= empDao.findEmpsByDeptName(name);
		
		if(emps.size()>0)
		{
			for(Employee e:emps)
			{
				System.out.println("Employee Id: "+e.getId());
				System.out.println("Employee name: "+e.getName());
				System.out.println("Designation: "+e.getDesg());
				System.out.println("Phone Number: "+e.getPhone());
				System.out.println("Email Id: "+e.getEmail());
				System.out.println("----------------");
			}
		}
		else {
			System.err.println("Invalid Department Name");
		}
		
	}
	
	public static void verifyEmpById()
	{
		System.out.println("Enter the employee id and Password to verify");
		int id =s.nextInt();
		String password=s.next();
		Employee e=empDao.verifyEmployee(id, password);
		if(e!=null)
		{
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} 
		else 
		{
			System.err.println("Invalid Id or password");
		}
	}
	
	public static void verifyEmpByPhone()
	{
		System.out.println("Enter the employee Phone and Password to verify");
		long phone =s.nextLong();
		String password=s.next();
		Employee e=empDao.verifyEmployee(phone, password);
		if(e!=null)
		{
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} 
		else 
		{
			System.err.println("Invalid Phone or password");
		}
	}
	
	
	public static void verifyEmpByEmail()
	{
		System.out.println("Enter the employee Email and Password to verify");
		String email =s.next();
		String password=s.next();
		Employee e=empDao.verifyEmployee(email, password);
		if(e!=null)
		{
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} 
		else 
		{
			System.err.println("Invalid Email or password");
		}
	}
	
	public static void findDeptById()
	{
		int dept_id=s.nextInt();
		Department d=deptDao.findById(dept_id);
		if (d != null) {
			System.out.println("Department Id:" + d.getId());
			System.out.println("Department Name:" + d.getName());
			System.out.println("Location:" + d.getLocation());
		} else {
			System.err.println("Invalid Department Id");
		}
	}
	
}
