package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;
import util.HibernateUtils;

public class DeleteCourse {
	private static SessionFactory factory = null;
	private static Session session = null;

	public static void main(String[] args) {

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Course sql = session.get(Course.class, 2);
			System.out.println("Deleting : "+ sql);
	
			session.delete(sql);
			tx.commit();
			System.out.println("Deleted!");

		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
}
