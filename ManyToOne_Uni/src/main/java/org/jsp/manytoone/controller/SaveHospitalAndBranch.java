package org.jsp.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Branch;
import org.jsp.manytoone.dto.Hospital;

public class SaveHospitalAndBranch {
  public static void main(String[] args) {
	Hospital h=new Hospital();
	h.setFounder("Anna");
	h.setName("apallo");
	h.setYoestb(1947);
	
	Branch b1=new Branch();
	b1.setEmail("abcd@gmail.com");
	b1.setName("apallo Delhi");
	b1.setPhone(973541);
	b1.setHospital(h);
	
	
	Branch b2=new Branch();
	b2.setEmail("abcb@gmail.com");
	b2.setName("apallo Bangalore");
	b2.setPhone(97354136);
	b2.setHospital(h);
	
	Branch b3=new Branch();
	b3.setEmail("abcm@gmail.com");
	b3.setName("apallo Mysore");
	b3.setPhone(8888777);
	b3.setHospital(h);
	
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(b1);
	manager.persist(b2);
	manager.persist(b3);
	transaction.begin();
	transaction.commit();
}
}
