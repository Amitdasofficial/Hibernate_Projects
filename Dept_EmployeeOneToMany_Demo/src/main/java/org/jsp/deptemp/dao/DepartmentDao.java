package org.jsp.deptemp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;
import org.jsp.deptemp.dto.Department;

public class DepartmentDao {
 static	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
	public static Department saveDept(Department department)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(department);
		transaction.begin();
		transaction.commit();
		return department;
	}
	
	public static Department updateDept(Department department)
	{
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(department);
		transaction.begin();
		transaction.commit();
		return department;
	}
	
	public static Department findDeptById(int id)
	{
		return manager.find(Department.class, id);
	}

}
