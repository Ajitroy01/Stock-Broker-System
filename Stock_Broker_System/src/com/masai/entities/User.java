package com.masai.entities;
import java.io.Serializable;
public class User implements Serializable {
private	String email;
private	String username;
private	String password;
private Long panCard;
public User(){
	super();
}
public User(String email, String username, String password, Long panCard) {
	this.email = email;
	this.username = username;
	this.password = password;
	this.panCard = panCard;
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
public Long getPanCard() {
	return panCard;
}
public void setPanCard(Long panCard) {
	this.panCard = panCard;
}
@Override
public String toString() {
	return "User [email=" + email + ", username=" + username + ", password=" + password + ", panCard=" + panCard + "]";
}
}
