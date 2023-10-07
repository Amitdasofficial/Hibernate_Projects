package org.jsp.deptemp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.deptemp.dao.DepartmentDao;
import org.jsp.deptemp.dao.EmployeeDao;
import org.jsp.deptemp.dto.Department;
import org.jsp.deptemp.dto.Employee;

public class Dept_Employee_Controller1 {
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
		case 3:
		{
			saveEmployee();
			break;
		}
		case 5: {
			FindEmpsByDeptId();
			break;
		}

		}

	}

	public static void saveDept() {
		System.out.println("Enter the name and location to save the department");
		Department d = new Department();
		d.setName(s.next());
		d.setLocation(s.next());
		d = deptDao.saveDept(d);
		System.out.println("Department save with Id: " + d.getId());
	}

	public static void updateDept() {
		System.out.println("Enter the Department id to update");
		int id = s.nextInt();
		System.out.println("Enter the name and location to update ");
		Department d = new Department();
		d.setId(id);
		d.setName(s.next());
		d.setLocation(s.next());
		d = deptDao.updateDept(d);
		System.out.println("Department Updated");
	}

	public static void FindEmpsByDeptId() {
		System.out.println("enter the Department Id to find employees");
		int id = s.nextInt();
		List<Employee> emps = empDao.findEmpsByDeptId(id);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id: " + e.getId());
				System.out.println("Employee name: " + e.getName());
				System.out.println("Designation: " + e.getDesg());
				System.out.println("Phone Number: " + e.getPhone());
				System.out.println("Email Id: " + e.getEmail());
				System.out.println("----------------");
			}
		} else {
			System.out.println("Invalid Department Id");
		}
	}

	public static void saveEmployee() {
		System.out.println("Enter the department id to add employee");
		int dept_id = s.nextInt();
		System.out.println("Enter the name desg, salary, phone email, password to save");
		Employee e = new Employee();
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setPassword(s.next());
		e=empDao.saveEmployee(e, dept_id);
		if (e != null) {
			System.out.println("Employee save With Id:" + e.getId());
		} else {
			System.err.println("Invalid Department Id");
		}
	}

}
