package com.SpringBootJDBC.SpringBootJDBC.model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Employee {
	@NotNull(message="ID can't be Null")
	private Long id;
	@NotEmpty(message="First Name can't be Empty")
	private String firstName;
	@NotEmpty(message="Last Name can't be Empty")
	@Size(min=3,message="Last Name minimum 3 letters")
	private String lastName;
	@NotNull(message="Mobile Number can't be Empty")
	private String mobileNumber;
	@NotEmpty(message="Email ID can't be Empty")
	private String emailId;
	@NotNull(message="Age can't be Empty")
	private Integer age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployeeRestController [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", age=" + age + "]";
	}
}
