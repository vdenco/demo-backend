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
    GroupModel grupo;

    BigDecimal prince;

    @OneToOne
    PrintersModel printer;

    String description;

    BigDecimal minStock;

    BigDecimal goalStock;

    String unit;

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

    public GroupModel getGrupo() {
        return grupo;
    }

    public void setGrupo(GroupModel grupo) {
        this.grupo = grupo;
    }

    public BigDecimal getPrince() {
        return prince;
    }

    public void setPrince(BigDecimal prince) {
        this.prince = prince;
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
}
