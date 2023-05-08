package com.masai.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Stocks;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.StockException;
import com.masai.exceptions.TransactionException;
public class CustomerServiceImp implements CustomerService {
@Override
public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException{
	if(customers != null && customers.containsKey(cus.getEmail())) {
		throw new DuplicateDataException("Account already exists, Please LogIn.");
	}
	else if(customers != null){
		customers.put(cus.getEmail(), cus);
	}
}
@Override
public boolean login(String email, String password, Map<String, Customer> customers) throws InvalidDetailsException {
	if(customers != null && customers.containsKey(email)) {
		if(customers.get(email).getPassword().equals(password)) {
			return true;
		}
		else {
			throw new InvalidDetailsException("Wrong Password !!");
		}
	}
	else {
		throw new InvalidDetailsException("Invalid Credentials.. Please SignUp.");
	}
}

@Override
public boolean buyStock(int id, int quantity, String email, Map<Integer, Stocks> stocks, Map<String, Customer> customers,
		List<Transaction> transactions) throws InvalidDetailsException,TransactionException, StockException {
if(stocks.size() == 0) {
	throw new  StockException ("Stocks sold out.");
}
if(stocks.containsKey(id)) {
	Stocks stock = stocks.get(id);
	if(stock.getQuantity() >= quantity) {
		Customer cus  = customers.get(email);
		double cost = quantity * stock.getPrice();
		if(cus.getWalletBalance() >= cost) {
			cus.setWalletBalance(cus.getWalletBalance() - cost);
			stock.setQuantity(stock.getQuantity() - quantity);
			stocks.put(id, stock);
			Transaction tr = new Transaction(cus.getUsername(), email, id, stock.getStockName(), quantity, stock.getPrice(), stock.getPrice() * quantity, LocalDate.now());
			transactions.add(tr);
		}
		else {
			throw new TransactionException("Insufficient Wallet Balance !!");
		}
	}
	else {
		throw new  StockException("Insufficient Stock Quantity !!");
	}
}
else {
	throw new InvalidDetailsException(id +" No stock exist with this id.");
}
return false;
}
@Override
public boolean addMoneyToWallet(double amount, String email, Map<String, Customer> customers) {
	Customer cus = customers.get(email);
	cus.setWalletBalance(cus.getWalletBalance() + amount);
	customers.put(email, cus);
	return true;
}
@Override
public boolean WithdrawMoneyFromWallet(double amount, String email, Map<String, Customer> customers) throws TransactionException {
	Customer cus = customers.get(email);
	if(cus.getWalletBalance() >= amount) {
		cus.setWalletBalance(cus.getWalletBalance() - amount);
		customers.put(email, cus);
		return true;
	}
	else {
		throw new TransactionException("Not enough money to widthdraw.");
	}
}
@Override
public boolean sellStock(int id, int qty, double price, String email, Map<Integer, Stocks> stock,
		Map<String, Customer> customers, List<Transaction> transactions)
		throws InvalidDetailsException,StockException{
	if(stock.containsKey(id)) {
		int loss;
		int profit;
		Stocks s = stock.get(id);
			Customer cus  = customers.get(email);
			double sellingPrice = qty*price;
			double margin =  sellingPrice - (qty * s.getPrice());
			if(margin < 1) {
				System.out.println("Stock has been sold and you have made a loss of "+ margin);
			}
			else {
				System.out.println("Stock has been sold and you have made a profit of "+ margin);
			}
			cus.setWalletBalance(cus.getWalletBalance() + sellingPrice);
			Transaction tr = new Transaction(cus.getUsername(), email, id, s.getStockName(), qty,price, sellingPrice, LocalDate.now());
			transactions.add(tr);
			return true;
	}
	else {
		throw new InvalidDetailsException(id +" No stock exist with this id.");
	}
}
@Override
public double viewWalletBalance(String email, Map<String, Customer> customers) {
	Customer cus = customers.get(email);
	double walletBalance = cus.getWalletBalance();
	return walletBalance;
}

@Override
public Customer viewCustomerDetails(String email, Map<String, Customer> customers) {
	if(customers.containsKey(email)) {
	return customers.get(email);
}
	return null;
}

@Override
public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws InvalidDetailsException {
	 List<Customer> list = null;
	 if(customers != null && customers.size() > 0) {
		 Collection<Customer> coll = customers.values();
		 list = new ArrayList<>(coll);
	 }
	 else {
		 throw new InvalidDetailsException("Customer list is Empty.");
	 }
	return list;
}
}
