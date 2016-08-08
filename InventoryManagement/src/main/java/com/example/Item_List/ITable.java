package com.example.Item_List;

import javax.persistence.Column;

/**
 * Created by sumi on 5/8/16.
 */
public class ITable {
    @Column(nullable = false)
    String[] item;
    @Column(nullable = false)
    int[] quantity;

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
}
