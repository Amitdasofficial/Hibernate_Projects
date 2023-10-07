package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class FindBatchById {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the id To find Batch");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();

	String hql = "SELECT b FROM Batch b WHERE b.id = ?1";

	Query q=manager.createQuery(hql);
	q.setParameter(1, id);
	List<Batch> batches=q.getResultList();
	if(batches.size()>0)
	{
		for(Batch b:batches)
		{
			System.out.println("batch id "+b.getId());
			System.out.println("Batch Code "+b.getCode());
			System.out.println("Subject "+b.getSubject());
			System.out.println("Trainer "+b.getTrainer());
			System.out.println("-----------------------");
		}
	}
	else
	{
		System.err.println("You have entered  an invalid id");
	}
}
}
