package com.example.Inventory_Master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sumi on 2/8/16.
 */
@Entity
public class intable implements Serializable
{
    @Id
    @GeneratedValue
    Long invenId=0L;
    @Column(nullable = false)
    String itemName;
    @Column(nullable = false)
    String unitMeasure;
    @Column(nullable = false)
    String dimension;
    @Column(nullable = false)
    int cost;
    @Column(nullable = false)
    int openBalance;
    @Column(nullable = false)
    int currBalance;

    public Long getinvenID()
    {
        return invenId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDimension() {
        return dimension;
    }

    public void setOpenBalance(int openBalance) {
        this.openBalance = openBalance;
    }

    public int getOpenBalance() {
        return openBalance;
    }

    public void setCurrBalance(int  currBalance) {
        this.currBalance = currBalance;
    }

    public int getCurrBalance() {
        return currBalance;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
