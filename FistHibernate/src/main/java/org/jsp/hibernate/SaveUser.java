package org.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {

	public static void main(String[] args) {
		User u= new User();
		u.setEmail("pqr@gmail.com");
		u.setName("pqr");
		u.setPassword("pqr123");
		u.setPhone(696978);
		Configuration cfg= new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s= factory.openSession();
		int id=(Integer) s.save(u);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("user registered with id:"+id);
	}
}
