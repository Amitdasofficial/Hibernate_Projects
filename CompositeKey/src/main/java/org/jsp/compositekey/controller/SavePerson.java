package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class SavePerson {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Name,phone,email, and Password to save");
		String name=s.next();
		long phone=s.nextLong();
		String email=s.next();
		String password=s.next();
		
		Person p=new Person();
		p.setName(name);
		p.setPassword(password);
		
		PersonId id= new PersonId();
		id.setEmail(email);
		id.setPhone(phone);
		p.setId(id);
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}

}
