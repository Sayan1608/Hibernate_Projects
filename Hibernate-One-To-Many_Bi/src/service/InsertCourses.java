package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;
import entity.Student;
import util.HibernateUtils;

public class InsertCourses {

	private static SessionFactory factory = null;
	private static Session session = null;

	public static void main(String[] args) {

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Student theStudent = session.get(Student.class, 1);

			Course course1 = new Course("Java");
			Course course2 = new Course("SQL");

			theStudent.addCourse(course1);
			theStudent.addCourse(course2);
			session.save(course1);
			session.save(course2);
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
