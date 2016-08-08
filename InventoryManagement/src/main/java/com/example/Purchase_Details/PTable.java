package com.example.Purchase_Details;

import javax.persistence.Column;

/**
 * Created by sumi on 4/8/16.
 */
public class PTable {

    @Column(nullable = false)
    String vendorName;
    @Column(nullable = false)
    double tax;
    @Column(nullable = false)
    String[] item;
    @Column(nullable = false)
    int [] quantity, cost1;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
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

    public int[] getCost1() {
        return cost1;
    }

    public void setCost1(int[] cost1) {
        this.cost1 = cost1;
    }
}
