package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class QueryingObjects {

	public static void main(String[] args) {
		System.out.println("Connecting to database...");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Transaction tx = null;
		List<Teacher> teachers = null;
		
		System.out.println("Connected :-)");
		
		try(Session session = factory.getCurrentSession()){
			tx = session.beginTransaction();
			 teachers = session.createQuery("from Teacher t where t.l_name like '%an'").list();
			tx.commit();
		}catch (Exception e) {
			System.out.println("Error.");
			e.printStackTrace();
			tx.rollback();
		}
		
		for(Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}

}
