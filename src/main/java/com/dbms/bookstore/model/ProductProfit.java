package com.dbms.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductProfit {
    @Id
    private int id;
    private long profit;
    private String name;
    private int storeId;

    public ProductProfit() {
    }

    public ProductProfit(int id, long profit, String name, int storeId) {
        this.id = id;
        this.profit = profit;
        this.name = name;
        this.storeId = storeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
