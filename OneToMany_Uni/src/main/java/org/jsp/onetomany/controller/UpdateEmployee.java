package org.jsp.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.jsp.onetomany.dto.Employee;

public class UpdateEmployee{
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
     Employee emp=manager.find(Employee.class, 1);
	emp.setName("Anirudh");
	emp.setDesg("Devops_d");
	emp.setSalary(9000);
	emp.setPhone(98756);
	emp.setEmail("ani@123");
	emp.setPassword("xyz123");
	
	manager.merge(emp);
	transaction.begin();
	transaction.commit();
	     
}
}
