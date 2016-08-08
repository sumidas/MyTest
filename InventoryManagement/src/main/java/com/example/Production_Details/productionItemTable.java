package com.example.Production_Details;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by sumi on 3/8/16.
 */
@Entity
//@javax.persistence.Table(name = "production_item_table")
public class productionItemTable implements Serializable
{
    @Id
    @GeneratedValue
    Long proItemId;
    String rawItem;
    int proItemQuan;

    public Long getProItemId() {
        return proItemId;
    }

    public void setRawItem(String rawItem) {
        this.rawItem = rawItem;
    }

    public String getRawItem() {
        return rawItem;
    }

    public void setProItemQuan(int proItemQuan) {
        this.proItemQuan = proItemQuan;
    }

    public int getProItemQuan() {
        return proItemQuan;
    }

}
