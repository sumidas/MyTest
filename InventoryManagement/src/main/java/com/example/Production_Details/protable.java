package com.example.Production_Details;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sumi on 2/8/16.
 */
@Entity
public class protable implements Serializable
{
    @Id
    @GeneratedValue
    Long proId;
    @Column(nullable = false)
    String proItem;
    @Column(nullable = false)
    Date proDate;
    @Column(nullable = false)
    int total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "production_item_table_pro_id")
    private Set<productionItemTable> proItemList;

    public Set<productionItemTable> getProItemList() {
        return proItemList;
    }

    public void setProItemList(Set<productionItemTable> proItemList) {
        this.proItemList = proItemList;
    }

    public Long getProId() {
        return proId;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public void setProItem(String proItem) {
        this.proItem = proItem;
    }

    public String getProItem() {
        return proItem;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }
}
