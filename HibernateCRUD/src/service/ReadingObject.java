package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import exceptions.TeacherNotFoundException;

public class ReadingObject {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		
		factory = new Configuration().configure().buildSessionFactory();
		System.out.println("created");
		
		System.out.println("Retrieving Teacher...");
		
		Transaction tx = null;
		
		try(Session session = factory.getCurrentSession()){
			tx = session.beginTransaction();
			Teacher theTeacher = session.get(Teacher.class, 5);
			if(theTeacher == null) {
				throw new TeacherNotFoundException("No Teacher exists with the given id");
			}
			
			System.out.println("Printing Teacher...\n"+theTeacher);
			tx.commit();
			
		}catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		}
	}

}
