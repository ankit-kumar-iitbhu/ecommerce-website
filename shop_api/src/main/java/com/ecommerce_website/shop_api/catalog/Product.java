package com.ecommerce_website.shop_api.catalog;

import com.ecommerce_website.shop_api.Constants;
import com.ecommerce_website.shop_api.bid.Bid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Product implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        private Integer productId;
        private String productName;
        private String productDescription;

        @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
        @JsonIgnore
        private Set<Bid> bids;

        public Product() {
            super();
        }

        public Product(String productName, String productDescription) {
            super();
            this.productName = productName;
            this.productDescription = productDescription;
        }

        @JsonProperty("productId")
        public Integer getProductId() {
            return productId;
        }

        @JsonIgnore
        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        @JsonProperty("href")
        public String getHREF() {
            return Constants.productUrl+"/"+ this.productId;
        }
}
