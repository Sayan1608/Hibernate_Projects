package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class SaveEmployee {

	public static void main(String[] args) {

		System.out.println("Connecting to Database");
		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			System.out.println("connected to Database :-)");

			tx = session.beginTransaction();

//			Employee emp1 = new Employee("Sayan", "Sengupta", 'M', 300000.00);
			Employee emp2 = new Employee("Nayan", "Halder", 'M', 350000.00);
			Employee emp3 = new Employee("Ankita", "Mishra", 'F', 400000.00);
			Employee emp4 = new Employee("Priyanka", "Sharma", 'F', 375000.00);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		}

	}

}
