package com.masai.services;

import java.util.Map;

import com.masai.entities.Stocks;
import com.masai.exceptions.StockException;

public class StocksServiceImp implements StocksService{
	@Override
	public String addStock(Stocks stock, Map<Integer, Stocks> stocks) {
		stocks.put(stock.getId(), stock);
		return "Stock Added Successfully.";
	}
	@Override
	public void viewAllStocks(Map<Integer, Stocks> stocks) throws  StockException {	
		if(stocks.size() > 0 && stocks != null) {
			for(Map.Entry<Integer, Stocks> entry : stocks.entrySet()) {
				Stocks v = entry.getValue();
				System.out.println(v);
			}
		}
		else {
			throw new  StockException("Stocks list is Empty.");
		}
	}

	@Override
	public void deleteStock(int id, Map<Integer, Stocks> stocks) throws  StockException {
		if(stocks != null && stocks.size() > 0) {
		if(stocks.containsKey(id)) {
	       stocks.remove(id);
	       System.out.println("Product deleted Successfully.");
		}
		else {
			throw new StockException(id + " Stock Not Exist !!");
		}
		}
		else {
			throw new  StockException("Stocks list is Empty.");
		}
	}

	@Override
	public String updateStock(int id, Stocks stock, Map<Integer, Stocks> stocks) throws  StockException {
		if(stocks != null && stocks.size() > 0) {
			if(stocks.containsKey(id)) {
				stocks.put(id, stock);
				return "Stock Updated Successfully.";
			}
			else {
				throw new StockException(id + " Stock Not Exist !!");
			}
		}
		else {
			throw new  StockException("Stocks list is Empty.");
		}
	}
}
