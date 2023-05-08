package com.masai.entities;

public class Customer extends User{
private transient double walletBalance;
public Customer() {
	super();
}
public Customer(String email, String fname, String lname, String username, String password, String address,
		Long mobile, double w) {
	super(email, fname, lname, username, password, address, mobile);
	this.walletBalance = w;
}

public double getWalletBalance() {
	return walletBalance;
}
public void setWalletBalance(double walletBalance) {
	this.walletBalance = walletBalance;
}
@Override
public String toString() {
	return "Name : " +super.getFname() + "  " + "Email : " + super.getEmail() +"  " + "Mobile : " + super.getMobile();
}
}
