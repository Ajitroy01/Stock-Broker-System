package com.masai.entities;
import java.io.Serializable;
public class Stocks  implements Serializable{
private int id;
private String company;
private static int quantity;
static {
	quantity = 500;
}
private String stockName;
private double price;

public Stocks() {
	super();
}
public Stocks(int id, String company, String stockName, double price) {
	super();
	this.id = id;
	this.company = company;
	this.stockName = stockName;
	this.price = price;
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
public static int getQuantity() {
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
	return "Stocks [id=" + id + ", company=" + company + ", stockName=" + stockName + ", price=" + price + "]";
}
}
