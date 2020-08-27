package com.ecommerce_website.shop_api.catalog;

import com.ecommerce_website.shop_api.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonIgnore
        private Integer productId;
        private String productName;
        private String productDescription;

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
