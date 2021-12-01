package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Employee;

public class EmployeeManager {
	protected SessionFactory sessionFactory;
	
	
	// CRUD
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.getStackTrace();
		}
		
	}
	
	protected void exit () {
		sessionFactory.close();
	}
	
	protected void create () {
		Employee employee = new Employee ();
		employee.setLastName("Nakamoto");
		employee.setFirstName("Satoshi");
		employee.setMailAdress("sato@gmail.com");
		employee.setRole("CEO");
		employee.setPhoneNumber(0606060606);
		employee.setAdress("1 rue des Huns");
		
		Employee employee1 = new Employee ();
		employee1.setLastName("Aouar");
		employee1.setFirstName("Houssem");
		employee1.setMailAdress("aouar@ol.fr");
		employee1.setRole("Developpeur");
		employee1.setPhoneNumber(0707070707);
		employee1.setAdress("2 rue des Deux");

		Employee employee2 = new Employee ();
		employee2.setLastName("Aouar");
		employee2.setFirstName("Houssem");
		employee2.setMailAdress("aouar@ol.fr");
		employee2.setRole("Chef");
		employee2.setPhoneNumber(0707070707);
		employee2.setAdress("2 rue des Deux");

		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee2);
		session.getTransaction().commit();
		
		session.close();
	}
	
	protected Employee findById (long id) {	
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		employee.toString();
		return employee;
	}
	
	protected void update (long id, Employee newEmployee) {	
		Employee employee = this.findById(id);
		
		if (newEmployee.getLastName() != null) {
			employee.setLastName(newEmployee.getLastName());
		}
		if (newEmployee.getFirstName() != null) {
			employee.setFirstName(newEmployee.getFirstName());
		}
//		if (newEmployee.getMailAdress() != null) {
//			employee.setMailAdress(newEmployee.getMailAdress());
//		}
		if (newEmployee.getRole() != null) {
			employee.setRole(newEmployee.getRole());
		}
//		if (newEmployee.getPhoneNumber() != employee.getPhoneNumber()) {
//			employee.setPhoneNumber(newEmployee.getPhoneNumber());
//		}
		if (newEmployee.getAdress() != null) {
			employee.setAdress(newEmployee.getAdress());
		}
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	
	protected void delete (Employee employee) {	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void main (String[] args) {
		EmployeeManager manager = new EmployeeManager();
		manager.setup();
//		manager.create(); // Create OK 
//		Employee employee = manager.findById(8); // toString n'affiche rien mais find OK
//		manager.delete(employee);	 // Delete OK
//		Employee employee = manager.findById(14); 
//		manager.update(10, employee);	// Update OK
		manager.exit();
	}
	

}
