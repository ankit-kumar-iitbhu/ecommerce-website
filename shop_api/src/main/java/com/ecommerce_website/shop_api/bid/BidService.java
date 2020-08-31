package com.ecommerce_website.shop_api.bid;

import com.ecommerce_website.shop_api.catalog.Product;
import com.ecommerce_website.shop_api.catalog.ProductRepository;
import com.ecommerce_website.shop_api.exception.CustomException;
import com.ecommerce_website.shop_api.vendor.Vendor;
import com.ecommerce_website.shop_api.vendor.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getAllBid() {
        List<Bid> bids = new ArrayList<>();
        bidRepository.findAll().forEach(bids::add);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    public ResponseEntity<Object> getBid(Integer id) throws CustomException {
        Optional<Bid> bidOptional = Optional.ofNullable(bidRepository.findById(id).orElse(null));
        if(!bidOptional.isPresent()){
            throw new CustomException("Bid with given ID does not exist",404);
        }
        else{
            return new ResponseEntity<>(bidOptional.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getBidByVendorId(Integer vendorId) {
        List<Bid> bids = new ArrayList<>();
        bidRepository.findByVendorVendorId(vendorId).forEach(bids::add);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    public ResponseEntity<Object> getBidByProductId(Integer productId) {
        List<Bid> bids = new ArrayList<>();
        bidRepository.findByProductProductId(productId).forEach(bids::add);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    public ResponseEntity<Object> addBid(BidDTO bidDTO) {
        Optional<Vendor> vendorOptional= Optional.ofNullable(
                vendorRepository.findById(bidDTO.getVendorId()).orElse(null));
        if(!vendorOptional.isPresent()){
            throw new CustomException("Vendor with given id does not exist.",404);
        }

        Optional<Product> productOptional = Optional.ofNullable(
                productRepository.findById(bidDTO.getProductId()).orElse(null));
        if(!productOptional.isPresent()){
            throw new CustomException("Product with given ID does not exist",404);
        }

        Bid bid=new Bid(bidDTO.getPrice(),productOptional.get(),vendorOptional.get());
        Bid savedBid= bidRepository.save(bid);
        return new ResponseEntity<>(savedBid, HttpStatus.CREATED);
    }




}
