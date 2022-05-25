package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;
import entity.Review;

public class InsertCoursesAndReviews {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Course theCourse = session.get(Course.class, 1);
			
			Review review1 = new Review("Excellent!");
			Review review2 = new Review("Very Nicely Explained :-)");
			
			theCourse.addReviews(review1);
			theCourse.addReviews(review2);
			
			session.save(review1);
			session.save(review2);
			
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
