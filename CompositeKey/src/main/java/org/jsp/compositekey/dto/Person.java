package org.jsp.compositekey.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person {
	@EmbeddedId
private PersonId id;
private String name;
private String password;
public PersonId getId() {
	return id;
}
public void setId(PersonId id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
