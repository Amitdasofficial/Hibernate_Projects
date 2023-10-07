package org.jsp.onetomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Employee;

public class FindEmpsByDeptId {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Department Id to Find Employees");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	String qry1="select e from Employee e where e.dept.id=?1";
	String qry2="select d.emps from Department d where d.id=?1";
	
	   Query q=manager.createQuery(qry1);
	q.setParameter(1, id);
	List<Employee>emps=q.getResultList();
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
		System.err.println("You have Entered an Invalid Department Id");
	}
	
	
}
}
