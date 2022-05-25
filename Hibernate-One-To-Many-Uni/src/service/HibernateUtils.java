package service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Review;
import entity.Teacher;
import entity.TeacherDetails;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
					.addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class).buildSessionFactory();
		}
		return sessionFactory;
	}
	
//	public static void main(String[] args) {
//		getSessionFactory();
//	}
}
