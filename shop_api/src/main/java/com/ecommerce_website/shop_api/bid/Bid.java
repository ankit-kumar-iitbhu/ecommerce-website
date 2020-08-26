package com.ecommerce_website.shop_api.bid;

import com.ecommerce_website.shop_api.catalog.Product;
import com.ecommerce_website.shop_api.vendor.Vendor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer bidId;

    private Double price;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="product_id",nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="vendor_id",nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

}
