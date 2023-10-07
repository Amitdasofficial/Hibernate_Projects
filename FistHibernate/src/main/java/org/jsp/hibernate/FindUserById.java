package org.jsp.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserById 
{
      public static void main(String[] args) 
    {
	   Session s= new Configuration().configure().buildSessionFactory().openSession();
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the User id  to Display");
	   int id=sc.nextInt();
	   User u=s.get(User.class, id);
	   if(u!=null)
	   {
		 System.out.println("userId: "+u.getId());
		 System.out.println("Email: "+u.getEmail());
		 System.out.println("phone "+u.getPhone());
		 System.out.println("Email "+u.getEmail());
	   }
	   else
	   {
		   System.err.println("You have entered an Invalid Id");
	   }
	}
	
	
}
