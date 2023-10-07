package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class SaveBatchandStudent {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	Batch b1=new Batch();
	b1.setSubject("Hibernate");
	b1.setTrainer("Sathish");
	b1.setCode("JBT-HIB");
	

	Batch b2=new Batch();
	b2.setSubject("J2EE");
	b2.setTrainer("GURU");
	b2.setCode("JBT-J2EE");
	

	Batch b3=new Batch();
	b3.setSubject("REACT");
	b3.setTrainer("Prajwal");
	b3.setCode("JBT-react");
	
	
	Student s1= new Student();
	s1.setName("virat");
	s1.setPerc(95);
	s1.setPhone(967845);
	
	Student s2= new Student();
	s2.setName("Hardik");
	s2.setPerc(80);
	s2.setPhone(9654638);
	
	Student s3= new Student();
	s3.setName("MSD");
	s3.setPerc(100);
	s3.setPhone(961256);
	
	b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2)));
	b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	
	manager.persist(b1);
	manager.persist(b2);
	manager.persist(b3);
	transaction.begin();
	transaction.commit();
	
}
}
