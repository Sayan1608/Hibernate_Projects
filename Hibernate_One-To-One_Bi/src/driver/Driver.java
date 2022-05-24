package driver;

import entity.Address;
import entity.Student;
import service.StudentCRUD;

public class Driver {

	public static void main(String[] args) {

		// create the objects
		Student tempStudent = new Student("Subhra", "Sen", "subhra123@greatlearning.com");

		Address tempAddress = new Address("CR Park", "New Delhi");

		// associate the objects
		tempStudent.setStudentAddress(tempAddress);

		StudentCRUD op1 = new StudentCRUD();
		op1.saveStudent(tempStudent);
		
		op1.removeStudent(4L);
//		op1.removeStudentAddress(3L);
		
		op1.readStudentDetails(5L);
		
		
		// closing all the connections
		op1.closeAllConnections();

	}

}
