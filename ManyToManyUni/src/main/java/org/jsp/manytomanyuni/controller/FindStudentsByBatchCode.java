package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Student;

public class FindStudentsByBatchCode {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Student batchcode To find Student");
	String code=s.next();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();

	String hql = "SELECT s FROM Student s WHERE s.code = ?1";

	Query q=manager.createQuery(hql);
	q.setParameter(1, code);
	List<Student> students=q.getResultList();
	if(students.size()>0)
	{
		for(Student x:students)
		{
			System.out.println("Student id:"+x.getId());
			System.out.println("Student Name "+x.getName());
			System.out.println("Student Percentage "+x.getPerc());
			System.out.println("Student Phone "+x.getPerc());
			System.out.println("-----------------------");
		}
	}
	else
	{
		System.err.println("You have entered an invalid Batch Code");
	}
}
}
