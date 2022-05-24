package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Address;
import entity.Student;

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

	public boolean removeStudentAddress(Long id) {

		try {
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Address address = session.get(Address.class, id);
			System.out.println("Removing the following student : " + address);
			session.delete(address);
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

	public void readStudentDetails(Long id) {

		try {
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Address address = session.get(Address.class, id);
			Student theStudent = address.getStudent();

			System.out.println("Address : \n" + address);
			System.out.println("Associated Student : \n" + theStudent);
			
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
		}

	}
	
	public  void closeAllConnections() {
		session.close();
		factory.close();
	}

}
