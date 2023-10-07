package org.jsp.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomany.dto.Answer;
import org.jsp.onetomany.dto.Question;

public class SaveQuestionAndAnswer {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Question q=new Question();
		q.setQuestion("What is Hibernate");
		q.setQuestionBy("Satish");
		
		
		Answer a1=new Answer();
		a1.setAnswer("Hibernate is a open Source Framework");
		a1.setAnswerBy("Anisha");
		
		

		Answer a2=new Answer();
		a2.setAnswer("Hibernate is a Non invasive,lightweight orm tool");
		a2.setAnswerBy("Bhumika");
		

		Answer a3=new Answer();
		a3.setAnswer("Hibernate is a ORM tool which connects jA and Db");
		a3.setAnswerBy("xyz");
		
		List<Answer> answers=new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		
		q.setAnswers(answers);
		manager.persist(q);
		transaction.begin();
		transaction.commit();
		}
}
