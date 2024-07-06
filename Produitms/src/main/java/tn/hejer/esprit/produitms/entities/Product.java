package tn.hejer.esprit.produitms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Builder

//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private int size;
        private String id_stock;
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
        public Product(Long id, String name, int size, String id_stock) {
            this.id = id;
            this.name = name;
            this.size = size;
            this.id_stock = id_stock;
        }
        public Product() {
        }



}

