import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatePerson {
public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	System.out.println("Enter the Person id to Update");
	int id=s.nextInt();
	Person p=new Person();
	System.out.println("Enter the age,name,phone,email,and Password to update");
	 p.setId(id);
	 p.setAge(s.nextInt());
	 p.setName(s.next());
	 p.setPhone(s.nextLong());
	 p.setEmail(s.next());
	 p.setPassword(s.next());
	 
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	 EntityManager manager=factory.createEntityManager();
	 EntityTransaction transaction=manager.getTransaction();
	 manager.merge(p);
	 transaction.begin();
	 transaction.commit();
	 System.out.println("Person Updated Successfully");
}
}
