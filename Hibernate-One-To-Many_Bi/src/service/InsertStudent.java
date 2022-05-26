package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Student;
import util.HibernateUtils;

public class InsertStudent {

	private static SessionFactory factory = null;
	private static Session session = null;

	public static void main(String[] args) {

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Student std1 = new Student("Sayan", "Sengupta", "sayan@greatLearning.com");
			session.save(std1);
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
}
