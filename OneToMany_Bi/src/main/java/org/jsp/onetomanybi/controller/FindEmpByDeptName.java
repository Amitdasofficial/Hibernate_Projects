package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmpByDeptName {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Department Name To display Employees");
	String name=s.next();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	String qry="select e from Employee e where e.dept.name=?1";
	Query q=manager.createQuery(qry);
	q.setParameter(1, name);
	List<Employee> emps=q.getResultList();
	if(emps.size()>0)
	{
		for(Employee e:emps)
		{

			System.out.println("Employee Id:"+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("Employee Desg:"+e.getDesg());
			System.out.println("Salary:"+e.getSalary());
			System.out.println("-----------------------");
		}
	}
	else
	{
		System.err.println("You have Enterd an Invalid Department name");
	}
}
}
