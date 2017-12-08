package com.example.demo.products;

import com.example.demo.group.GroupModel;
import com.example.demo.printers.PrintersModel;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToOne
    GroupModel group;

    BigDecimal price;

    @OneToOne
    PrintersModel printer;

    String description;

    BigDecimal minStock;

    BigDecimal goalStock;

    String unit;

    Boolean preferred;

    String ncm;

    String csosn;

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

    public GroupModel getGroup() {
        return group;
    }

    public void setGrupo(GroupModel group) {
        this.group = group;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal prince) {
        this.price = prince;
    }

    public PrintersModel getPrinter() {
        return printer;
    }

    public void setPrinter(PrintersModel printer) {
        this.printer = printer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMinStock() {
        return minStock;
    }

    public void setMinStock(BigDecimal minStock) {
        this.minStock = minStock;
    }

    public BigDecimal getGoalStock() {
        return goalStock;
    }

    public void setGoalStock(BigDecimal goalStock) {
        this.goalStock = goalStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }
}
