package com.masai.services;
import java.util.List;
import java.util.Map;
import com.masai.entities.Customer;
import com.masai.entities.Stocks;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.StockException;
import com.masai.exceptions.TransactionException;
public interface CustomerService {
	public boolean login(String email,String password, Map<String, Customer> customers) throws InvalidDetailsException;
	public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException;
	public boolean buyStock(int id, int qty, String email, Map<Integer, Stocks> stocks,
			Map<String, Customer> customers, List<Transaction> transactions)
			throws InvalidDetailsException,TransactionException,StockException;
	public boolean addMoneyToWallet(double amount, String email, Map<String, Customer> customers);
	public double viewWalletBalance(String email, Map<String, Customer> customers);
	public Customer viewCustomerDetails(String email, Map<String, Customer> customers);
	public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws InvalidDetailsException;
}
