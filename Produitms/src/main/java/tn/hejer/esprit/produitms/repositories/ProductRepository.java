package tn.hejer.esprit.produitms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.hejer.esprit.produitms.entities.Product;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

   // @Query(value = "select * from T_Product", nativeQuery = true)
//List<Product> all();


    //Product findById(long id);
}
