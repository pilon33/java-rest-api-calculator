package com.coralogix.calculator.model;

import javax.persistence.*;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String originCurrency;
    @Column
    private String finalCurrency;
    @Column
    private String date;
    @Column
    private String value;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public String getFinalCurrency() {
        return finalCurrency;
    }

    public void setFinalCurrency(String finalCurrency) {
        this.finalCurrency = finalCurrency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ExchangeRate(int id, String originCurrency, String finalCurrency, String date, String value) {
        this.id = id;
        this.originCurrency = originCurrency;
        this.finalCurrency = finalCurrency;
        this.date = date;
        this.value = value;
    }

    public ExchangeRate(){

    }
}
