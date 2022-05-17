package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class RemoveEmployee {

	public static void main(String[] args) {
		System.out.println("Connecting to Database");

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			System.out.println("connected to Database :-)");

			tx = session.beginTransaction();

//			Employee theEmployee = session.get(Employee.class, 4);
//			System.out.println(theEmployee);
//			System.out.println("Removing "+ theEmployee.getF_name());
//			session.delete(theEmployee);
//			System.out.println("removed...");

			session.createQuery("delete from Employee where f_name = 'Ankit'")
					.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		}
	}

}
