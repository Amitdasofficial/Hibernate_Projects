package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class FindPerson {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the email id and phone number to find Person");
	String email=s.next();
	long phone=s.nextLong();
	
	
	PersonId id= new PersonId();
	id.setEmail(email);
	id.setPhone(phone);
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	Person p=manager.find(Person.class, id);
	if(p!=null)
	{
		System.out.println("Name: "+p.getName());
		System.out.println("EmailId: "+p.getId().getEmail());
		System.out.println("Phone Number: "+p.getId().getPhone());
	}
	else
	{
		System.out.println("Invalid Credentials");
	}
}
}
