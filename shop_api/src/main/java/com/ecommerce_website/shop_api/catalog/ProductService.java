package com.ecommerce_website.shop_api.catalog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product postProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Integer id,Product product) {
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
