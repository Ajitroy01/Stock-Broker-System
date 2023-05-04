package com.masai.entities;

public class Customer extends User{
private double walletBalance;
public Customer() {
	super();
}
public Customer(String email, String username, String password, String panCard, double w) {
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
	return "Customer [walletBalance=" + walletBalance + "]";
}
}
