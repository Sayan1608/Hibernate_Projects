package service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import entity.Project;
import utility.HibernateUtils;

public class InsertEmployeeAndProject {

	public static void main(String[] args) {

		SessionFactory factory = null;
		Session session = null;

		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

//			Employee emp1 = new Employee("Rohan", "Agarwal", "896704@cognizant.com");
			Employee theEmployee = session.get(Employee.class, 1);

//			Project project1 = new Project("Amazon Cloud Services");
//			Project project2 = new Project("Netfix");
			
			Project project1 = session.get(Project.class, 1);
			

			Set<Project> projectList1 = new HashSet<>();
//			projectList1.add(project1);
			
			projectList1.add(project1);

			theEmployee.setProjects(projectList1);

//			session.save(project1);
//			session.save(project2);

//			session.save(emp1);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
