package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class FindPersonByPhone {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the phone number to find Person");
        long phone = s.nextLong();
        
        EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
        
        PersonId pid = new PersonId();
        pid.setPhone(phone);
        
        Person p = manager.find(Person.class, pid);
        
        if (p != null) {
            System.out.println("Name: " + p.getName());
            System.out.println("Phone Number: " + p.getId().getPhone());
        } else {
            System.err.println("Person not found");
        }
    }
}
