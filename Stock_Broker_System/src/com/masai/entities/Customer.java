package com.masai.entities;

public class Customer extends User{
private transient double walletBalance;
public Customer() {
	super();
}
public Customer(String email, String username, String password, Long panCard, double w) {
	super(email, username, password, panCard);
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
	return "Name : " +super.getUsername() + "  " + "Email : " + super.getEmail() +"  " + "Pan : " + super.getPanCard();
}
}
