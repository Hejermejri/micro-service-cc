package tn.esprit.stockms.services;

import tn.esprit.stockms.entities.Stock;

import java.util.List;
import java.util.Map;


public interface IStockService {

    Stock addStock(Stock stock);

    Stock updateStock(String id, Map<String, Object> stock);

    List<Stock> getAllStock();

    Stock getStockById(String id);

    void deleteStockById(String id);

}
