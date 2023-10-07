import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson
{
public static void main(String[] args) 
 {
	Person p=new Person();
	p.setName("mnp");
	p.setAge(20);
	p.setPhone(76677);
	p.setEmail("mpn@777");
	p.setPassword("mnp123");
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	manager.persist(p);
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	transaction.commit();
	System.out.println("Person Saved with Id:"+p.getId());
}
}
