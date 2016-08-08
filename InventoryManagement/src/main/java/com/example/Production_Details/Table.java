package com.example.Production_Details;

import javax.persistence.Column;

/**
 * Created by sumi on 3/8/16.
 */
public class Table {
    @Column(nullable = false)
    String proName;
    @Column(nullable = false)
    String [] item;
    @Column(nullable = false)
    int [] quantity;
    @Column(nullable = false)
    int total;


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String[] getItem() {
        return item;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
