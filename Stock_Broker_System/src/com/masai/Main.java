package com.masai;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.masai.entities.Customer;
import com.masai.entities.Stocks;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.StockException;
import com.masai.exceptions.TransactionException;
import com.masai.services.CustomerService;
import com.masai.services.CustomerServiceImp;
import com.masai.services.StocksService;
import com.masai.services.StocksServiceImp;
import com.masai.services.TransactionService;
import com.masai.services.TransactionServiceImp;
import com.masai.utility.Broker;
import com.masai.utility.FileExists;
import com.masai.utility.IdGenerator;

public class Main {

	public static void brokerFunctions(Scanner sc, Map<Integer, Stocks> stock, Map<String, Customer> cus, List<Transaction> transactions) throws
	InvalidDetailsException, StockException, TransactionException{
		brokerLogin(sc);
		CustomerService cusservice = new CustomerServiceImp();
	   StocksService  stockservice = new   StocksServiceImp();
	   TransactionService trservice = new TransactionServiceImp();
	   int choice = 0;
			do {
				try {
				System.out.println("Press 1 -> Add Stock");
				System.out.println("Press 2 -> View All Stock");
				System.out.println("Press 3 -> Delete any Stock");
				System.out.println("Press 4 -> Update any Stock");
				System.out.println("Press 5 -> View All Customers");
				System.out.println("Press 6 -> Delete Any Customer");
				System.out.println("Press 7 -> View All Transactions");
				System.out.println("Press 8 ->  Log Out !");
				choice = sc.nextInt();
				switch(choice) {
				case 1 : String msg = brokerAddStock(sc, stock, stockservice);
				System.out.println(msg);
				break;
				case 2 : brokerViewAllStocks(stock, stockservice);
				break;
				case 3 : brokerDeleteStock(sc, stock, stockservice);
				break;
				case 4 : String up = brokerUpdateStock(sc, stock, stockservice);
				System.out.println(up);
				break;
				case 5 : brokerViewAllCustomer(cus, cusservice);
				break;
				case 6 : brokerDeleteCustomer(sc, cus);
				break;
				case 7 : brokerViewAllTransaction( transactions, trservice);
				break;
				case 8 : System.out.println("Logout Successfull.");
				break;
				default : 
					throw new IllegalArgumentException("Wrong Value : " + choice);
				} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			} while(choice <=7);
	}
	public static void brokerLogin(Scanner sc) throws InvalidDetailsException {
		System.out.println("Enter your UserName");
		String userName = sc.next();
		System.out.println("Enter your Password");
		String pass = sc.next();
		if(userName.equals(Broker.username) && pass.equals(Broker.password)) {
			System.out.println("Login Successfull...");
		}
		else {
			throw new InvalidDetailsException("Wrong Credentials !!!");
		}
	}
	public static String brokerAddStock(Scanner sc, Map<Integer, Stocks> stock, StocksService stockservice) {
		String str = null;
		System.out.println("Please enter the stock details.");
		System.out.println("Please enter Company Name.");
		String company = sc.next();
		System.out.println("Please enter stock name.");
		String name = sc.next();
		System.out.println("Please enter price of the stock.");
		double p = sc.nextDouble();
		Stocks stocks = new Stocks(IdGenerator.generateId(), company, name, p, 500);
		str = stockservice.addStock(stocks, stock);
		return str;
	}
	public static void brokerViewAllStocks(Map<Integer, Stocks> stock, StocksService stockservice) throws StockException {
		stockservice.viewAllStocks(stock);
	}
	public static void brokerDeleteStock(Scanner sc, Map<Integer, Stocks> stock, StocksService stockservice ) throws StockException {
		System.out.println("Please enter the stock details.");
		System.out.println("Please enter Stock ID.");
		int id = sc.nextInt();
		stockservice.deleteStock(id, stock);
	}
	public static String brokerUpdateStock(Scanner sc, Map<Integer, Stocks> stock, StocksService stockservice) throws StockException {
		String str = null;
		System.out.println("Please enter the stock details.");
		System.out.println("Please enter Stock ID.");
		int id = sc.nextInt();
		System.out.println("Please enter the updated details.");
		System.out.println("Please enter Company Name.");
		String company = sc.next();
		System.out.println("Please enter stock name.");
		String name = sc.next();
		System.out.println("Please enter price of the stock.");
		double p = sc.nextDouble();
		Stocks s = new Stocks(IdGenerator.generateId(), company, name, p, 500);
		str = stockservice.updateStock(id, s, stock);
		return str;
	}
	public static void brokerViewAllCustomer(Map<String, Customer> cus, CustomerService cusservice) throws InvalidDetailsException {
		List<Customer> list = cusservice.viewAllCustomers(cus);
		for(Customer c : list) {
				System.out.println(c);
		}
	}
	public static boolean brokerDeleteCustomer(Scanner sc, Map<String, Customer> cus) {
		System.out.println("Please enter Email of Customer.");
		 String email = sc.next();
		if(cus.size() > 0 &&  cus.containsKey(email)) {
			cus.remove(email);
			System.out.println("Customer Deleted from App.");
			return true;
		}
		return false;
	}
	public static void brokerViewAllTransaction(List<Transaction> transactions, TransactionService transactionService) throws TransactionException {
		List<Transaction> alltr = transactionService.viewAllTransactions(transactions);
		for(Transaction tr : alltr) {
			System.out.println(tr);
		}
	}
	
	
	public static void customerFunctions(Scanner sc, Map<String, Customer> cus, Map<Integer,Stocks>stock, List<Transaction>transactions) throws InvalidDetailsException {
		CustomerService cusservice = new CustomerServiceImp();
		   StocksService  stockservice = new   StocksServiceImp();
		   TransactionService trservice = new TransactionServiceImp();
		   System.out.println("Please enter the following details -:");
		   System.out.println("Please enter your Email");
		   String email = sc.next();
		   System.out.println("Please enter your Password");
		   String pass = sc.next();
		   customerLogIn(email, pass, cus, cusservice);
		   int choice = 0;
			   do {
				   try {
				   System.out.println("Please select an option");
				   System.out.println("Press 1 ->  To View All Stocks");
				   System.out.println("Press 2 -> To Buy Any Stock");
				   System.out.println("Press 3 -> Add Money to Wallet");
				   System.out.println("Press 4 -> To Sell Any Stock");
				   System.out.println("Press 5 -> View Wallet Balance");
				   System.out.println("Press 6 -> Widthraw Money from Wallet");
				   System.out.println("Press 7 -> View My Account Details");
				   System.out.println("Press 8 -> View My Transactions");
				   System.out.println("Press 9 -> Logout.");
				   choice = sc.nextInt();  
				   switch (choice) {
					case 1:
						customerViewAllProducts(stock, stockservice);
						break;
					case 2:
						String result = customerBuyStock(sc, email, stock, cus, transactions, cusservice);
						System.out.println(result);
						break;
					case 3:
						String moneyAdded = customerAddMoneyToWallet(sc, email, cus, cusservice);
						System.out.println(moneyAdded);
						break;
					case 4:
						customerSellStock(sc, email, stock, cus, transactions, cusservice);
						break;
					case 5:
						double walletBalance = customerViewWalletBalance(email, cus, cusservice);
						System.out.println("Wallet balance is: " + walletBalance);
						break;
					case 6:
						String moneydebit = customerWithdrawMoneyFromWallet(sc, email, cus, cusservice);
						System.out.println(moneydebit);
						break;
					case 7:
						customerViewMyDetails(email, cus, cusservice);
						break;
					case 8:
						customerViewCustomerTransactions(email, transactions, trservice);
						break;
					case 9:
						System.out.println("you have successsfully logout");
						break;
					default:
						System.out.println("invalid choice");
						break;
					}
				   }
			 catch (Exception e) {
				System.out.println(e.getMessage());
			 }
			} while (choice <= 8);
		}
	public static void customerSignUp(Scanner sc, Map<String, Customer> cus ) throws DuplicateDataException {
		System.out.println("Please enter the following details to create Demat Account -:");
		System.out.println("Please enter Email");
		String email = sc.next();
		System.out.println("Please enter Firstname");
		String fname = sc.next();
		System.out.println("Please enter Lastname");
		String lname = sc.next();
		System.out.println("Please enter Username");
		String username = sc.next();
		System.out.println("Please enter Password");
		String pass = sc.next();
		System.out.println("Please enter Address Details");
		String Address = sc.next();
		System.out.println("Please enter Mobile Number");
		Long mobile = sc.nextLong();
		System.out.println("Please enter amount to be added in your Wallet.");
		Double amount = sc.nextDouble();
		Customer c = new Customer(email, fname, lname, username, pass, Address, mobile, amount );
		CustomerService cs = new CustomerServiceImp();
		cs.signUp(c, cus);
		System.out.println("Account Created Successfully.");	
	}
	public static void customerLogIn(String email , String pass,  Map<String, Customer> cus, CustomerService cusservice) throws InvalidDetailsException {
		cusservice.login(email, pass, cus);
		System.out.println("Login Successfull.");
	}
	public static void customerViewAllProducts(Map<Integer, Stocks> stock, StocksService stockservice)
			throws StockException {
		stockservice.viewAllStocks(stock);
	}
	public static String customerBuyStock(Scanner sc, String email, Map<Integer, Stocks> stock,
			Map<String, Customer> customers, List<Transaction> transactions, CustomerService cusservice)
			throws InvalidDetailsException, StockException, TransactionException {
		System.out.println("Please Enter the Stock ID");
		int id = sc.nextInt();
		System.out.println("Please Enter Quantity.");
		int qty = sc.nextInt();
		cusservice.buyStock(id, qty, email, stock, customers, transactions);
		return "You have successfully bought the stock.";
	}
	public static String customerAddMoneyToWallet(Scanner sc, String email, Map<String, Customer> customers,
			CustomerService cusservice) {
		System.out.println("please enter the amount");
		double money = sc.nextDouble();
		boolean added = cusservice.addMoneyToWallet(money, email, customers);

		return "Amount: " + money + " Credited to your wallet.";
	}
	public static String customerWithdrawMoneyFromWallet(Scanner sc, String email, Map<String, Customer> customers,
			CustomerService cusservice) throws TransactionException {
		System.out.println("Please enter the amount");
		double money = sc.nextDouble();
		boolean widthdraw = cusservice.WithdrawMoneyFromWallet(money, email, customers);
		return "Amount: " + money + " is debited from your wallet and added to your Bank Account.";
	}
	public static void customerSellStock(Scanner sc, String email, Map<Integer, Stocks> stock,
			Map<String, Customer> customers, List<Transaction> transactions, CustomerService cusservice)
			throws InvalidDetailsException, StockException, TransactionException {
		System.out.println("Please Enter the Stock ID");
		int id = sc.nextInt();
		System.out.println("Please Enter Quantity.");
		int qty = sc.nextInt();
		System.out.println("Please Enter Selling Price.");
		int price = sc.nextInt();
		cusservice.sellStock(id, qty, price, email, stock, customers, transactions);
	}
	public static double customerViewWalletBalance(String email, Map<String, Customer> customers,
			CustomerService cusservice) {
		double walletBalance = cusservice.viewWalletBalance(email, customers);
		return walletBalance;
	}
	public static void customerViewMyDetails(String email, Map<String, Customer> customers,
			CustomerService cusservice) {
		Customer cus = cusservice.viewCustomerDetails(email, customers);
		System.out.println("Name : " + cus.getFname());
		System.out.println("Username : " + cus.getUsername());
		System.out.println("Email : " + cus.getEmail());
		System.out.println("Address : " + cus.getAddress());
		System.out.println("Wallet Balance : " + cus.getWalletBalance());
	}
	public static void customerViewCustomerTransactions(String email, List<Transaction> transactions,
			TransactionService trnsactionService) throws TransactionException {
		List<Transaction> myTransactions = trnsactionService.viewCustomerTransactions(email, transactions);
		for (Transaction tr : myTransactions) {
			System.out.println(tr);
		}
	}
	
	
	public static void main(String[] args) {
		
				Map<Integer, Stocks> stocks = FileExists.stocksFile();
				Map<String, Customer> customers = FileExists.customerFile();
				List<Transaction> transactions = FileExists.transactionFile();
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome , in Stock Broker System");
				int preference = 0;
				do {
				try {
					do {
						System.out.println("Please enter your preference");
						System.out.println("Press 1 : Broker Login");
						System.out.println("Press 2 : Customer Login");
						System.out.println("Press 3 : Customer SignUp");
						System.out.println("Press 0 : Exit");	
						preference = sc.nextInt();
						switch (preference) {
						case 1:
							brokerFunctions(sc, stocks, customers, transactions);
							break;
						case 2:
							customerFunctions(sc, customers, stocks, transactions);
							break;
						case 3:
							customerSignUp(sc, customers);
							break;
						case 0:
							System.out.println("Successfully exited from the system");
							break;
						default:
							throw new IllegalArgumentException("Invalid Selection");
						}
					}
					while (preference != 0);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				finally {
					try {
						ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Stocks.ser"));
						poos.writeObject(stocks);
						ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Customers.ser"));
						coos.writeObject(customers);
						ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("Transactions.ser"));
						toos.writeObject(transactions);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}while (preference != 0);
	}
	}

