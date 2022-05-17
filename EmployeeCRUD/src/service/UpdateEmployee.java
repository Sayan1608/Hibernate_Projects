package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

	public static void main(String[] args) {
		System.out.println("Connecting to Database");

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.getCurrentSession()) {

			System.out.println("connected to Database :-)");

			tx = session.beginTransaction();

//			Employee theEmployee = session.get(Employee.class, 1);
//			theEmployee.setSalary(450000.00);
//			session.update(theEmployee);

			session.createQuery("update Employee set f_name = 'Ankit', l_name = 'Prashad' where f_name = 'Ankita'")
					.executeUpdate();
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
			tx.rollback();
		}
	}

}
