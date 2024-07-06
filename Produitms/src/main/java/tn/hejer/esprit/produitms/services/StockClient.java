package tn.hejer.esprit.produitms.services;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.hejer.esprit.produitms.entities.StockDTO;

@FeignClient(name = "api", url = "http://localhost:8095")
public interface StockClient {

    @GetMapping("/api/getbyid/{id}")
        StockDTO getById(@PathVariable("id") String id);



}
