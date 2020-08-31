package com.ecommerce_website.shop_api.vendor;

import com.ecommerce_website.shop_api.Constants;
import com.ecommerce_website.shop_api.bid.Bid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer vendorId;
    private String vendorName;
    private String vendorContactDetail;

    @OneToMany(mappedBy = "vendor",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Bid> bids;

    public Vendor() {
        super();
    }

    public Vendor(String name, String contactDetail) {
        super();
        this.vendorName = name;
        this.vendorContactDetail = contactDetail;
    }

    @JsonProperty("vendorId")
    public Integer getVendorId() {
        return vendorId;
    }

    @JsonIgnore
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorContactDetail() {
        return vendorContactDetail;
    }

    public void setVendorContactDetail(String vendorContactDetail) {
        this.vendorContactDetail = vendorContactDetail;
    }

    @JsonProperty("href")
    public String getHREF() {
        return Constants.vendorUrl +"/"+ this.vendorId;
    }

}
