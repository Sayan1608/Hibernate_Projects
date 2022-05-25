package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;

public class RetrieveCourseAndReview {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Course theCourse = session.get(Course.class, 1);

			System.out.println("Course : " + theCourse);
			System.out.println("Associated Reviews : " + theCourse.getReviews());

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
