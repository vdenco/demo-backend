package com.example.demo.sale;

import com.example.demo.products.ProductsModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.engine.spi.Mapping;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class SaleItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    ProductsModel product;

    BigDecimal amount;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="sale_model_id",referencedColumnName = "id")
    @JsonBackReference
    SaleModel saleModel;

    public SaleItemModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductsModel getProduct() {
        return product;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public SaleModel getSaleModel() {
        return saleModel;
    }

    public void setSaleModel(SaleModel saleModel) {
        this.saleModel = saleModel;
    }
}
