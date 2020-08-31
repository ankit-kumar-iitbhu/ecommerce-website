package com.ecommerce_website.shop_api.bid;

import com.ecommerce_website.shop_api.Constants;
import com.ecommerce_website.shop_api.catalog.Product;
import com.ecommerce_website.shop_api.vendor.Vendor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer bidId;

    private Double price;

    @ManyToOne(fetch=FetchType.EAGER,optional = false)
    @JoinColumn(name="product_id",nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch=FetchType.EAGER,optional = false)
    @JoinColumn(name="vendor_id",nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Vendor vendor;


    public Bid() {
        super();
    }

    public Bid(Double price, Product product, Vendor vendor) {
        super();
        this.price = price;
        this.product = product;
        this.vendor = vendor;
    }

    @JsonProperty("bidId")
    public Integer getBidId() {
        return bidId;
    }

    @JsonIgnore
    public void setBidId(Integer bid) {
        this.bidId = bid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("product")
    //@JsonIgnore
    public Product getProduct() {
        return this.product;
    }

    @JsonIgnore
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("vendor")
    //@JsonIgnore
    public Vendor getVendor() {
        return this.vendor;
    }

    @JsonIgnore
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @JsonProperty("href")
    public String getHREF() {
        return Constants.bidUrl +"/"+ this.bidId;
    }
}

