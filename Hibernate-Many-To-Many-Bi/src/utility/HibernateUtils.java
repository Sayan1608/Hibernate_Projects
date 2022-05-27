package utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;
import entity.Project;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Project.class).buildSessionFactory();
		}
		return sessionFactory;
	}
}
