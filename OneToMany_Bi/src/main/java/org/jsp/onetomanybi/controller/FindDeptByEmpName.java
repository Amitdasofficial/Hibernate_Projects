package org.jsp.onetomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FindDeptByEmpName {
   public static void main(String[] args) {
	EntityManager manager =Persistence.createEntityManagerFactory("dev").createEntityManager();
	Scanner s= new Scanner(System.in);
	System.out.println("Enter the Employee name to print Department details");
	String name=s.next();
	String qry="select e.dept from Employee e where e.name=?1";
	
	Query q=manager.createQuery(qry);
	q.setParameter(1, name);
	try {
		Department d=(Department) q.getSingleResult();
		System.out.println("Department id:"+d.getName());
		System.out.println("Department Name:"+d.getName());
		System.out.println("Location:"+d.getLocation());
		
		
	} catch (NoResultException e) {
		System.err.println("Invalid Employee Name");
	}
}
}
