package com.ecommerce_website.shop_api.vendor;

import com.ecommerce_website.shop_api.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer vendorId;
    private String vendorName;
    private String vendorContactDetail;

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
        return Constants.vendorUrl + this.vendorId;
    }

}
