package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Teacher;
import entity.TeacherDetails;

public class InsertTeacherAndTeacherDetails {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			TeacherDetails teacherDetails = new TeacherDetails("Bangalore", "Photography");
			Teacher theTeacher = new Teacher("Pradeep", "Kumar", "pradeep@gl.com");
			theTeacher.setTeacherDetails(teacherDetails);
			session.save(theTeacher);
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
