package org.jsp.deptemp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.deptemp.dto.Department;

public class DepartmentDao {

	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	
	public Department saveDepartment(Department department)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(department);
		transaction.begin();
		transaction.commit();
		return department;
	}
	

	public Department updateDepartment(Department department)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(department);
		transaction.begin();
		transaction.commit();
		return department;
	}

	public Department findById(int id) {
		return manager.find(Department.class, id);
	}
}
