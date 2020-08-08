package com.ecommerce_website.shop_api.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //exposed to client
    @RequestMapping("/products")
    public ResponseEntity<Object> getAllProduct(){
        return productService.getAllProduct();
    }

    @RequestMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    //admin access
    @RequestMapping(value="/products",method= RequestMethod.POST)
    public ResponseEntity<Object> postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }

    //admin access
    @RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.updateProduct(id,product);
    }

    //admin access
    @RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer id) {
        return productService.deleteProduct(id);
    }

/*
    //exposed to client
    @RequestMapping("/products/{id}/bids")
    public List<Bid> getBids(@PathVariable("id") Integer id){
        return productService.getBids(id);
    }

 */

}
