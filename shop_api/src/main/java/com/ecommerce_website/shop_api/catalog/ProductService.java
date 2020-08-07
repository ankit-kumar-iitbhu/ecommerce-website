package com.ecommerce_website.shop_api.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce_website.shop_api.exception.CustomException;
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

    public Product getProduct(Integer id) throws CustomException {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id).orElse(null));
        if(!productOptional.isPresent()){
            throw new CustomException("Product with given ID does not exist",404);
        }
        else{
            return productOptional.get();
        }
    }

    public Product postProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Integer id,Product product) throws CustomException {
        if(!productRepository.existsById(id)){
            throw new CustomException("Product with given ID does not exist",404);
        }
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Integer id) {
        if(!productRepository.existsById(id)){
            throw new CustomException("Product with given ID does not exist",404);
        }
        productRepository.deleteById(id);
    }



}
