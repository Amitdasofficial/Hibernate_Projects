package org.jsp.onetomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.dto.Department;

public class FetchDeptByEmpId {
	public static void main(String[] args) {
		EntityManager manager =Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Employee Id to print Department Details");
		int eid=s.nextInt();
		String qry="select e.dept from Employee e where e.id=?1";
		
		
		Query q=manager.createQuery(qry);
		q.setParameter(1, eid);
		try {
			Department d=(Department) q.getSingleResult();
			System.out.println("Department Id:"+d.getId());
			System.out.println("Department Name:"+d.getName());
			System.out.println("Location"+d.getLocation());
			
		} catch (NoResultException e) {
			System.err.println("Invalid Emloyee Id");
		}
		
	}
}
