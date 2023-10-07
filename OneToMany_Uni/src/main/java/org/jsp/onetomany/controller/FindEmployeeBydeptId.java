package org.jsp.onetomany.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomany.dto.Employee;

public class FindEmployeeBydeptId {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Department id to find Employee");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	//String qry="Select e from Employee e where e.dept.id=?1";
	String qry1="Select d.emps from department d where d.id=?1";
	Query q=manager.createQuery(qry1);
	q.setParameter(1, id);
	
	List<Employee> emps=q.getResultList();
	if(emps.size()>0) {
		for(Employee e:emps)
		{
			System.out.println("Employee id: "+e.getId());
			System.out.println("Employee Name :"+e.getName());
			System.out.println("Employee Salary:"+e.getSalary());
			System.out.println("Employee Phone"+e.getPhone());
			System.out.println("Employee email "+e.getEmail());
			System.out.println("Employee password "+e.getPassword());
			System.out.println("------------------------------");
		}
	
		
	}
	else
	{
		System.err.println("You have Entered an Invalid department Id");
	}
	
	
}
}
