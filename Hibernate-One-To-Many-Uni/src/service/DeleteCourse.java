package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;

public class DeleteCourse {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			int course_id = 2;
			Course theCourse = session.get(Course.class, course_id);
			System.out.println("Deleting : " + theCourse);
			
			session.delete(theCourse);
			System.out.println("Deleted!");
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
