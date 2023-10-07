package org.jsp.hibernate;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class VerifyUserByIdPassword 
{
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter User id & Password to verify");
	 int id=sc.nextInt();
	 String password=sc.next();
	 String qry="select u from User u where u.id=?1 and u.password=?2";
	 Session s= new Configuration().configure().buildSessionFactory().openSession();
	 Query<User> q=s.createQuery(qry);
	
	     q.setParameter(1, id);
	     q.setParameter(2, password);
	     try {
			User u=q.getSingleResult();
			System.out.println("id:"+u.getId());
			System.out.println("name:"+u.getName());
			System.out.println("phone no:"+u.getPhone());
	    	 
		} catch (NoResultException e) {
			System.err.println("You have entered invalid Id or Password");
		}
}
}
