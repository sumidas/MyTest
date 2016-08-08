package com.example.Item_List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sumi on 5/8/16.
 */
@Entity
public class ItemTable implements Serializable
{
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String itemToPurchase;
    @Column(nullable = false)
    int itemQuanToPurchase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemToPurchase() {
        return itemToPurchase;
    }

    public void setItemToPurchase(String itemToPurchase) {
        this.itemToPurchase = itemToPurchase;
    }

    public int getItemQuanToPurchase() {
        return itemQuanToPurchase;
    }

    public void setItemQuanToPurchase(int itemQuanToPurchase) {
        this.itemQuanToPurchase = itemQuanToPurchase;
    }
}
