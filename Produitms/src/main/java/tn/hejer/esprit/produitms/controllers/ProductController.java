package tn.hejer.esprit.produitms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.hejer.esprit.produitms.entities.Product;
import tn.hejer.esprit.produitms.entities.ProduitWithStockDTO;
import tn.hejer.esprit.produitms.services.IProductService;
import tn.hejer.esprit.produitms.services.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private IProductService ps;
    //@Autowired
    //private ProductService ps;

    @GetMapping("/getProducts")
    public List<ProduitWithStockDTO> getAllProducts(){
        return ps.reteriveAllProducts();
    }
    @GetMapping("/getProductById/{id}")
    public ProduitWithStockDTO getProductById(@PathVariable("id") Long id){
        return ps.getProductById(id);
    }

    @PostMapping("/saveProduit")
    public ProduitWithStockDTO add(@RequestBody ProduitWithStockDTO produit) {
        return ps.addProduct(produit);

    }

    @PatchMapping("/updateProduit/{id}")
    public Product update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ps.updateProduit(id, updates);

    }
    @DeleteMapping("/deleteProduit/{id}")
    public void delete(@PathVariable("id") Long id) {
        ps.deleteProduitById(id);

    }
}
