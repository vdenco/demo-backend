package com.example.demo.sale;

public enum SaleStatus {

    WAITING(1);

    long id;

    SaleStatus(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
