package com.example.Purchase_Details;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by sumi on 2/8/16.
 */
@Entity
public class purtable implements Serializable
{
    @Id
    @GeneratedValue
    Long purId;
    @Column(nullable = false)
    String vendorName;
    @Column(nullable = false)
    Date purDate;
    @Column(nullable = false)
    double tax;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_item_table_pur_id")
    private Set<purchaseItemTable> purItemList;

    public Set<purchaseItemTable> getPurItemList() {
        return purItemList;
    }

    public void setPurItemList(Set<purchaseItemTable> purItemList) {
        this.purItemList = purItemList;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurId(Long purId) {
        this.purId = purId;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public Long getPurId() {
        return purId;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

}
