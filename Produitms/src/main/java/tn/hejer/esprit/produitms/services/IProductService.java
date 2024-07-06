package tn.hejer.esprit.produitms.services;

import tn.hejer.esprit.produitms.entities.Product;
import tn.hejer.esprit.produitms.entities.ProduitWithStockDTO;

import java.util.List;
import java.util.Map;

public interface IProductService {

    List<ProduitWithStockDTO> reteriveAllProducts();

    void deleteProduitById(Long id);
    ProduitWithStockDTO addProduct(ProduitWithStockDTO p);

    ProduitWithStockDTO getProductById(Long id);

    Product updateProduit(Long id, Map<String, Object> produit);

}
