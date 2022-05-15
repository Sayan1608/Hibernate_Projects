package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class DeletingObjects {

	public static void main(String[] args) {
		System.out.println("Connecting to Database...");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Transaction tx = null;
		
		System.out.println("Connected  :-)");
		
		try(Session session = factory.getCurrentSession()){
			tx = session.beginTransaction();
			
			/*
			 * Teacher theTeacher = session.get(Teacher.class, 2);
			 * System.out.println(theTeacher); System.out.println("Deleting...");
			 * session.delete(theTeacher); System.out.println("Deleted");
			 */
			session.createQuery("delete from Teacher t where t.email = 'vikesh@gmail.com'")
			.executeUpdate();
			System.out.println("Deleted");
			tx.commit();
		}catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
		}
	}

}
