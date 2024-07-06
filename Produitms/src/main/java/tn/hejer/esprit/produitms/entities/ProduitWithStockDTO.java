package tn.hejer.esprit.produitms.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
public class ProduitWithStockDTO {private Long id;
    private String name;
    private int size;
    private String id_stock;
    private StockDTO stockdto;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getId_stock() {
        return id_stock;
    }
    public void setId_stock(String id_stock) {
        this.id_stock = id_stock;
    }
    public StockDTO getStockdto() {
        return stockdto;
    }
    public void setStockdto(StockDTO stockdto) {
        this.stockdto = stockdto;
    }
    public ProduitWithStockDTO() {
        super();
    }




}
