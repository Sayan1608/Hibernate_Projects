package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import utility.HibernateUtils;

public class InsertEmployee {

	public static void main(String[] args) {

		SessionFactory factory = null;
		Session session = null;

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Employee emp1 = new Employee("Sayan", "Sengupta", "894807@cognizant.com");

			session.save(emp1);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
