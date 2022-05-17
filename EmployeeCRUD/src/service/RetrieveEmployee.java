package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class RetrieveEmployee {

	public static void main(String[] args) {
		System.out.println("Connecting to Database");

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			System.out.println("connected to Database :-)");

			tx = session.beginTransaction();

			List<Employee> emps = session.createQuery("from Employee where gender = 'F'").list();
//			Employee theEmployee = session.get(Employee.class, 1);
			tx.commit();

			for (Employee emp : emps) {
				System.out.println(emp);
			}
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		}

	}

}
