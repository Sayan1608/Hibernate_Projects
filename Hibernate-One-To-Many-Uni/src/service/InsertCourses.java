package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Course;
import entity.Teacher;

public class InsertCourses {

	public static void main(String[] args) {

		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			int t_id = 1;

			// get the teacher from db
			Teacher theTeacher = session.get(Teacher.class, t_id);

			// create courses
			Course course1 = new Course("Java Programming");
			Course course2 = new Course("ORM and Hibernate");

			// associate the courses
//			theTeacher.add(course1);
			theTeacher.add(course2);

			// save the courses in db
//			session.save(course1);
			session.save(course2);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
