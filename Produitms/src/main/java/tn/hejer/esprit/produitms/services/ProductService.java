package tn.hejer.esprit.produitms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.hejer.esprit.produitms.entities.Product;
import tn.hejer.esprit.produitms.entities.ProduitWithStockDTO;
import tn.hejer.esprit.produitms.entities.StockDTO;
import tn.hejer.esprit.produitms.mappers.ArticleMappers;
import tn.hejer.esprit.produitms.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository pRepo;

    @Autowired
    private StockClient stockClient;

    @Override
    public List<ProduitWithStockDTO> reteriveAllProducts() {
        return pRepo.findAll().stream().map(produit -> ArticleMappers.mapToDto(produit))
                .collect(Collectors.toList());

        //return (List<Product>) pRepo.findAll();
    }

    @Override
    public ProduitWithStockDTO addProduct(ProduitWithStockDTO p) {
        pRepo.save(ArticleMappers.mapToEntity(p));
        return p;
        //return pRepo.save(p);
    }

    @Override
    public ProduitWithStockDTO getProductById(Long id) {
        Product produit = pRepo.findById(id).get();

        //OpenFeign
        StockDTO stockDTO = stockClient.getById(produit.getId_stock());

        //RestTemplate
        //StockDTO stockDTO =getById(article.getId_stock());
        return ArticleMappers.mapToDto(produit, stockDTO);

        //return pRepo.findById(id);
    }

    @Override
    public Product updateProduit(Long id, Map<String, Object> produit) {
        Product isProduit = pRepo.findById(id).get();

        if (isProduit == null) {

            return null;
        }

        for (Map.Entry<String, Object> entry : produit.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            try {
                Field field = isProduit.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(isProduit, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return pRepo.save(isProduit);
    }

    @Override
    public void deleteProduitById(Long id) {
        pRepo.deleteById(id);

    }

    public StockDTO getById(String id) {
        String url = "http://localhost:8095/api/getbyid/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, StockDTO.class);
    }
}
