package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class UpdatingObject {

	public static void main(String[] args) {
		System.out.println("Connceting to Database...");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Transaction tx = null;
		
		System.out.println("Connected :-)");
		
		try(Session session = factory.getCurrentSession()){
			tx = session.beginTransaction();
			Teacher theTeacher = session.get(Teacher.class, 1);
			System.out.println(theTeacher);
			System.out.println("Updating teacher...");
			theTeacher.setF_name("Partha Pratim");
			session.update(theTeacher);
			
			System.out.println("Updated Teacher.");
			
			session.createQuery("update Teacher t set t.email = 'parthapratim@gl.com' where t.f_name = 'Partha Pratim'")
			.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			tx.rollback();
		}
	}

}
