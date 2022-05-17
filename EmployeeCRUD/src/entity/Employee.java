package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	@Column(name = "f_name")
	private String f_name;
	
	@Column(name = "l_name")
	private String l_name;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "salary")
	private double salary;

	public Employee() {
		super();
	}

	public Employee(String f_name, String l_name, char gender, double salary) {
		super();
		this.emp_id = emp_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.gender = gender;
		this.salary = salary;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", f_name=" + f_name + ", l_name=" + l_name + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}

}
