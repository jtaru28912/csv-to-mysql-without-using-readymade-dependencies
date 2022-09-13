package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeAssignment")
public class Employee {
	// ID IS A PRIMARY KEY
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String age;
	private String salary;
	private String emailId;

	// PARAMETERIZED CONSTRUCTOR
	public Employee(String firstName, String middleName, String lastName, String age, String salary, String emailId) {
		super();

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.emailId = emailId;
	}

	// DEFAULT CONSTRUCTOR
	public Employee() {
		super();
	}

	// GETTERS AND SETTERS
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String data) {
		this.age = data;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
