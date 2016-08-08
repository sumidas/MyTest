package com.example.Purchase_Details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sumi on 3/8/16.
 */
@Entity
public class purchaseItemTable {

    @Id
    @GeneratedValue
    Long purItemId;
    String purItem;
    int purItemQuan, purItemCost;

    public Long getPurItemId() {
        return purItemId;
    }

    public void setPurItemId(Long purItemId) {
        this.purItemId = purItemId;
    }

    public String getPurItem() {
        return purItem;
    }

    public void setPurItem(String purItem) {
        this.purItem = purItem;
    }

    public int getPurItemQuan() {
        return purItemQuan;
    }

    public void setPurItemQuan(int purItemQuan) {
        this.purItemQuan = purItemQuan;
    }

    public int getPurItemCost() {
        return purItemCost;
    }

    public void setPurItemCost(int purItemCost) {
        this.purItemCost = purItemCost;
    }
}
