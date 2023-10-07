package org.jsp.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchUser 
{
   public static void main(String[] args)
   {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the User id to print details");
	    int uid=sc.nextInt();
	    Session s= new Configuration().configure().buildSessionFactory().openSession();
	    User u=s.load(User.class, uid);
	    try {
			System.out.println("id: "+u.getId());
			System.out.println("Name: "+u.getName());
			System.out.println("Phone "+u.getPhone());
			System.out.println("Email "+u.getEmail());
			
		} catch (Exception e) {
			System.err.println("You have Entered an Invalid Id");
			
		}
   }
}
