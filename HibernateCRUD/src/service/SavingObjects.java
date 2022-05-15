package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class SavingObjects {

	public static void main(String[] args) {
		System.out.println("Connecting to Database...");
		SessionFactory factory = null;
//		Session session = null;
		Transaction tx = null;

		factory = new Configuration().configure().buildSessionFactory();

		System.out.println("created");

		// inserting or saving objects in teacher table
		try (Session session = factory.getCurrentSession();) {

			tx = session.beginTransaction();

			Teacher t1 = new Teacher("Vikesh", "Pandey", "vikesh@gmail.com");
			Teacher t2 = new Teacher("Kaushik", "Sarkar", "kaushik@gmail.com");
//			Teacher t3 = new Teacher("Bala", "R Subramanian", "bala@gmail.com");
//			Teacher t4 = new Teacher("Tazeen", "Khan", "tazeen@gmail.com");

			session.save(t1);
			session.save(t2);
//			session.save(t3);
//			session.save(t4);
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error...");
			e.printStackTrace();
			tx.rollback();
		} 

	}

}
