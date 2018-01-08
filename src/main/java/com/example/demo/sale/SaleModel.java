package com.example.demo.sale;

import com.example.demo.products.ProductsModel;
import com.example.demo.table.TableModel;
import com.example.demo.users.UserModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy="saleModel", cascade = CascadeType.ALL, targetEntity = SaleItemModel.class)
    @JsonManagedReference
    List<SaleItemModel> products;

    @OneToOne
    UserModel user;

    @OneToOne
    TableModel table;

    String obs;

    Long status = SaleStatus.WAITING.getId();

    @CreationTimestamp
    Date date;

    public SaleModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItemModel> getProducts() {
        return products;
    }

    public void setProducts(List<SaleItemModel> products) {
        this.products = products;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = table;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @PrePersist
    public void addItems(){
        if(products != null) {
            for (SaleItemModel saleItemModel : products) {
                saleItemModel.setSaleModel(this);
            }
        }else{
            System.out.println("VAZIO");
        }
    }
}
