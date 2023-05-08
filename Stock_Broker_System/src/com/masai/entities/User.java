package com.masai.entities;
import java.io.Serializable;
public class User implements Serializable {
private	String email;
private String fname;
private String lname;
private	String username;
private	String password;
private String address;
private Long mobile;
public User(){
	super();
}
public User(String email, String fname, String lname, String username, String password, String address, Long mobile) {
	this.email = email;
	this.fname = fname;
	this.lname = lname;
	this.username = username;
	this.password = password;
	this.address = address;
	this.mobile = mobile;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Email : " + email + "Name : " + fname + " Address : " + address + "  Mobile : " + mobile;
}
}
