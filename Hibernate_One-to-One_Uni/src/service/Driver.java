package service;

import entity.Address;
import entity.Student;

public class Driver {

	public static void main(String[] args) {

		// create the objects
		Student tempStudent = new Student("Ayush", "Kumar", "ayush@greatlearning.com");

		Address tempAddress = new Address("West Bengal", "Durgapur");

		// associate the objects
		tempStudent.setStudentAddress(tempAddress);

		StudentCRUD op1 = new StudentCRUD();
//		op1.saveStudent(tempStudent);
		
//		op1.removeStudent(7L);

	}

}
