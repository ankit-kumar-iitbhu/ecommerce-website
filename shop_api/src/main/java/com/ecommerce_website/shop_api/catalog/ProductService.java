package com.ecommerce_website.shop_api.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce_website.shop_api.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getAllProduct(){
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<Object> getProduct(Integer id) throws CustomException {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id).orElse(null));
        if(!productOptional.isPresent()){
            throw new CustomException("Product with given ID does not exist",404);
        }
        else{
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> postProduct(Product product) {
        Product savedProduct= productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateProduct(Integer id,Product product) throws CustomException {
        if(!productRepository.existsById(id)){
            throw new CustomException("Product with given ID does not exist",404);
        }
        product.setProductId(id);
        Product updatedProduct=productRepository.save(product);

        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteProduct(Integer id) {
        if(!productRepository.existsById(id)){
            throw new CustomException("Product with given ID does not exist",404);
        }
        productRepository.deleteById(id);
        return new ResponseEntity<>("product with productId = "+id+" has been deleted", HttpStatus.NO_CONTENT);
    }


}
