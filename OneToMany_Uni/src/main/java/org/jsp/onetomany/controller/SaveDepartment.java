package org.jsp.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomany.dto.Department;
import org.jsp.onetomany.dto.Employee;

public class SaveDepartment {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Department d=new Department();
		   d.setName("Java");
		   d.setLocation("Bangalore");
		   
		   Employee e=new Employee();
		   e.setName("Amit");
		   e.setDesg("Java_Developer");
		   e.setSalary(50000);
		   e.setPhone(97351);
		   e.setEmail("amit@gmail.com");
		   e.setPassword("amit123");
		   
		   Employee e1=new Employee();
		   e1.setName("Prayag");
		   e1.setDesg("Java_Developer");
		   e1.setSalary(40000);
		   e1.setPhone(9735145);
		   e1.setEmail("prayag@gmail.com");
		   e1.setPassword("prayag123");
		   
		   List<Employee> emps=new ArrayList<Employee>();
		   emps.add(e);
		   emps.add(e1);
		   d.setEmps(emps);
		   manager.persist(d);
		   transaction.begin();
		   transaction.commit();
	}

}
