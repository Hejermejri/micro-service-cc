package tn.esprit.stockms.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockms.entities.Stock;
import tn.esprit.stockms.repositories.StockRepository;

@Service
public class StockService implements IStockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public Stock updateStock(String id, Map<String, Object> stock) {
        Stock existingStock = stockRepository.findById(id).get();

        if (existingStock == null) {

            return null;
        }

        for (Map.Entry<String, Object> entry : stock.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = existingStock.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(existingStock, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stockRepository.save(existingStock);


    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(String id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public void deleteStockById(String id) {
        stockRepository.deleteById(id);

    }

}
