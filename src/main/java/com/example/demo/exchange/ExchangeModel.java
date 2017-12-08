package com.example.demo.exchange;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ExchangeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    BigDecimal dolar;

    BigDecimal euro;

    BigDecimal guarani;

    BigDecimal real;

    BigDecimal peso;

    @CreationTimestamp
    Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDolar() {
        return dolar;
    }

    public void setDolar(BigDecimal dolar) {
        this.dolar = dolar;
    }

    public BigDecimal getEuro() {
        return euro;
    }

    public void setEuro(BigDecimal euro) {
        this.euro = euro;
    }

    public BigDecimal getGuarani() {
        return guarani;
    }

    public void setGuarani(BigDecimal guarani) {
        this.guarani = guarani;
    }

    public BigDecimal getReal() {
        return real;
    }

    public void setReal(BigDecimal real) {
        this.real = real;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
}
