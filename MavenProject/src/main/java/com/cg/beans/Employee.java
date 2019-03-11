package com.cg.beans;

public class Employee {
private int employeeId;
private String firstName;
private String lastName;
private String mobileNo;
private String email;
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
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
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int employeeId, String firstName, String lastName, String mobileNo, String email) {
	super();
	this.employeeId = employeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mobileNo = mobileNo;
	this.email = email;
}
@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNo="
			+ mobileNo + ", email=" + email + "]";
}

}
