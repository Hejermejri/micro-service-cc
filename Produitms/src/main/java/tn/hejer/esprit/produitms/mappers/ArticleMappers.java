package tn.hejer.esprit.produitms.mappers;

import tn.hejer.esprit.produitms.entities.Product;
import tn.hejer.esprit.produitms.entities.ProduitWithStockDTO;
import tn.hejer.esprit.produitms.entities.StockDTO;

public class ArticleMappers {

    public static ProduitWithStockDTO mapToDto(Product produit) {

        ProduitWithStockDTO articleDTO = ProduitWithStockDTO.builder().id(produit.getId()).name(produit.getName())
                .size(produit.getSize()).id_stock(produit.getId_stock()).build();
        return articleDTO;
    }

    public static ProduitWithStockDTO mapToDto(Product produit, StockDTO stockDTO) {

        ProduitWithStockDTO produitDTO = ProduitWithStockDTO.builder().id(produit.getId()).name(produit.getName())
                .size(produit.getSize()).id_stock(produit.getId_stock()).stockdto(stockDTO).build();

        return produitDTO;
    }

    public static Product mapToEntity(ProduitWithStockDTO produitDTO) {
        Product produit = Product.builder().id(produitDTO.getId()).name(produitDTO.getName()).size(produitDTO.getSize())
                .id_stock(produitDTO.getStockdto().getId()).build();
        return produit;

    }

}

