package com.example.demo.productProduct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ProductProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    BigDecimal stock;

    BigDecimal price;

    BigDecimal stockMinimun;

    String unity;


}
