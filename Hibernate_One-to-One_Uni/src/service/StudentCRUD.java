package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Student;
import hibernate_utils.HibernateUtils;

public class StudentCRUD {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction tx = null;

	public Student saveStudent(Student std) {

		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			session.save(std);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();

		}
		return std;

	}

	public boolean removeStudent(Long stdId) {

		try {
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Student theStudent = session.get(Student.class, stdId);
			System.out.println("Removing the following student : " + theStudent);
			session.delete(theStudent);
			tx.commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			session.close();

		}
		return false;

	}

}
