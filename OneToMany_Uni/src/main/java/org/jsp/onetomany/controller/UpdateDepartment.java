package org.jsp.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomany.dto.Department;

public class UpdateDepartment {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Department d=manager.find(Department.class, 1);
	d.setName("Python_dev");
	d.setLocation("Kolkata");
	manager.merge(d);
	transaction.begin();
	transaction.commit();
	     
}
}
