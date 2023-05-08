package com.masai.entities;
import java.io.Serializable;
public class Stocks  implements Serializable{
private int id;
private String company;
private int quantity;
private String stockName;
private double price;

public Stocks() {
	super();
}
public Stocks(int id, String company, String stockName, double price, int qty) {
	super();
	this.id = id;
	this.company = company;
	this.stockName = stockName;
	this.price = price;
	this.quantity = qty;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getStockName() {
	return stockName;
}
public void setStockName(String stockName) {
	this.stockName = stockName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "ID : "+id+"    " +"Company : "+company + "    " + "Name : " + stockName + "     " +"Quantity : " + quantity +"   "  + "Price  : " +price; 
}
}
