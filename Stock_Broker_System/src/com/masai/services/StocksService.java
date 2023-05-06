package com.masai.services;
import java.util.Map;
import com.masai.entities.Stocks;
import com.masai.exceptions.StockException;
public interface StocksService {
	public String addStock(Stocks stock, Map<Integer, Stocks> stocks);
	public void viewAllStocks(Map<Integer, Stocks> stocks) throws StockException;

	public void deleteStock(int id, Map<Integer, Stocks> stocks) throws  StockException;

	public String updateStock(int id, Stocks stock, Map<Integer, Stocks> stocks) throws  StockException;
}
