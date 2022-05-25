package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Teacher;

public class RetrieveTeacherAndCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Teacher theTeacher = session.get(Teacher.class, 1);
			
			System.out.println("Teacher : "+theTeacher);
			System.out.println("Associated Courses : " + theTeacher.getCourses());
			
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
