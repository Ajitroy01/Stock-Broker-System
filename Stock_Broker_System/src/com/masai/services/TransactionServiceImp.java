package com.masai.services;
import java.util.ArrayList;
import java.util.List;
import com.masai.entities.Customer;
import com.masai.entities.Transaction;
import com.masai.exceptions.TransactionException;
public class TransactionServiceImp implements TransactionService {
	@Override
	public List<Transaction> viewCustomerTransactions(String email, List<Transaction> transactions)
			throws TransactionException {
		List<Transaction> transaction = new ArrayList<>();
		boolean flag = false;
		for(Transaction tr : transactions) {
			transaction.add(tr);
			flag = true;
		}
	    if(!flag) {
	    	throw new TransactionException("No transaction has been made by you till now.");
	    }
		return transaction;
	}

	@Override
	public List<Transaction> viewAllTransactions(List<Transaction> transactions) throws TransactionException {
		List<Transaction> transaction = new ArrayList<>();
  if(transactions != null && transactions.size() > 0) {
	  for(Transaction tr : transactions) {
			transaction.add(tr);
  }
  }
  else {
	  throw new TransactionException("No transaction has been made.");
  }
  return transaction;
	}

}
