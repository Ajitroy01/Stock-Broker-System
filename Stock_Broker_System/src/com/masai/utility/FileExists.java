package com.masai.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Stocks;
import com.masai.entities.Transaction;
public class FileExists {
public static Map<Integer, Stocks> stocksFile(){
	Map<Integer, Stocks> stocks = null;
	File f = new File("Stocks.ser");
	boolean flag = false;
	try {
		if(!f.exists()) {
			f.createNewFile();
			flag = true;
		}
		if(flag) {
			stocks = new LinkedHashMap<>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f)); 
			oos.writeObject(stocks);
			return stocks;
		}
		else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			stocks = (Map<Integer, Stocks>) ois.readObject();
			return stocks;
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return stocks;
}
public static Map<String, Customer> customerFile(){
	Map<String, Customer> cus = null;
	File f = new File("Customers.ser");
	boolean flag = false;
	try {
		if(!f.exists()) {
			f.createNewFile();
			flag = true;
		}
		if(flag) {
			cus = new HashMap<>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f)); 
			oos.writeObject(cus);
			return cus;
		}
		else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			cus = (Map<String, Customer>) ois.readObject();
			return cus;
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return cus;
}
public static List<Transaction> transactionFile() {
	List<Transaction> trans = null;
	File f = new File("Transactions.ser");
	boolean flag = false;
	try {
		if (!f.exists()) {
			f.createNewFile();
			flag = true;
		}
		if (flag) {
			trans =  new ArrayList<>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(trans);
			return trans;
		} else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			trans = (List<Transaction>) ois.readObject();
			return trans;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return trans;
}
}

