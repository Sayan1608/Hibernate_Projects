package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import entity.Project;
import utility.HibernateUtils;

public class DeleteEmployee {

	public static void main(String[] args) {

		SessionFactory factory = null;
		Session session = null;

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Employee theEmployee = session.get(Employee.class, 2);
			System.out.println("Removing Employee : " + theEmployee);
			System.out.println("Associated Projects : ");
			
			for(Project project : theEmployee.getProjects()) {
				System.out.println(project);
			}
			
			session.delete(theEmployee);
			
			tx.commit();
			
			System.out.println("Deleted!");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
}
