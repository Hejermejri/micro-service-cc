package tn.esprit.stockms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.stockms.entities.Stock;


public interface StockRepository extends MongoRepository<Stock, String>{

}
