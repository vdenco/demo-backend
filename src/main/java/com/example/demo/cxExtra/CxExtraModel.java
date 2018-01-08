package com.example.demo.cxExtra;

import com.example.demo.client.ClientModel;
import com.example.demo.table.TableModel;
import com.example.demo.users.UserModel;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CxExtraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    UserModel userModel;

    BigDecimal total;

    BigDecimal valueGuarani;

    BigDecimal valuePeso;

    BigDecimal valueDolar;

    BigDecimal valueEuro;

    BigDecimal valueReal;

    BigDecimal creditCard;

    BigDecimal debitCard;

    @CreationTimestamp
    Date date;

    BigDecimal toReceive;

    @OneToOne
    ClientModel clientModel;

    @OneToOne
    TableModel tableModel;

    BigDecimal change;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValueGuarani() {
        return valueGuarani;
    }

    public void setValueGuarani(BigDecimal valueGuarani) {
        this.valueGuarani = valueGuarani;
    }

    public BigDecimal getValuePeso() {
        return valuePeso;
    }

    public void setValuePeso(BigDecimal valuePeso) {
        this.valuePeso = valuePeso;
    }

    public BigDecimal getValueDolar() {
        return valueDolar;
    }

    public void setValueDolar(BigDecimal valueDolar) {
        this.valueDolar = valueDolar;
    }

    public BigDecimal getValueEuro() {
        return valueEuro;
    }

    public void setValueEuro(BigDecimal valueEuro) {
        this.valueEuro = valueEuro;
    }

    public BigDecimal getValueReal() {
        return valueReal;
    }

    public void setValueReal(BigDecimal valueReal) {
        this.valueReal = valueReal;
    }

    public BigDecimal getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(BigDecimal creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(BigDecimal debitCard) {
        this.debitCard = debitCard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getToReceive() {
        return toReceive;
    }

    public void setToReceive(BigDecimal toReceive) {
        this.toReceive = toReceive;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }
}
