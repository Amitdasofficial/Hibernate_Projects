package org.jsp.manytoone.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

   @Entity
public class Hospital {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,founder;
	private int yoestb;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public int getYoestb() {
		return yoestb;
	}
	public void setYoestb(int yoestb) {
		this.yoestb = yoestb;
	}
	
}
