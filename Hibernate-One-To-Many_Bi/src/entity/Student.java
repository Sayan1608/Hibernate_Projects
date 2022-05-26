package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int student_id;

	@Column(name = "f_name")
	private String f_name;

	@Column(name = "l_name")
	private String l_name;

	@Column(name = "email", unique = true)
	private String email;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Course> courses;

	public Student() {
		super();
	}

	public Student(String f_name, String l_name, String email) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email
				+ "]";
	}

	// utility method to add Courses to a Student

	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(course);
		course.setStudent(this);
	}

}
