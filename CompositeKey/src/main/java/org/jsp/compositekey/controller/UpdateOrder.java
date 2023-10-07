package org.jsp.compositekey.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.FoodOrder;

public class UpdateOrder {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	FoodOrder order=manager.find(FoodOrder.class, 1);
	order.setFood_item("Fried Rice");
	order.setCost(120);
	
	manager.merge(order);
	transaction.begin();
	transaction.commit();
}
}
