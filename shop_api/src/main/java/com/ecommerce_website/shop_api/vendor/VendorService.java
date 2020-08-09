package com.ecommerce_website.shop_api.vendor;


import com.ecommerce_website.shop_api.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    public ResponseEntity<Object> getAllVendor() {
        List<Vendor> vendors = new ArrayList<>();
        vendorRepository.findAll().forEach(vendors::add);
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    public ResponseEntity<Object> getVendor(int id) throws CustomException{
        Optional<Vendor> vendor= Optional.ofNullable(vendorRepository.findById(id).orElse(null));
        if(!vendor.isPresent()){
            throw new CustomException("Vendor with given id does not exist.",404);
        }
        else {
            return new ResponseEntity<>(vendor.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> addVendor(Vendor vendor) {
        Vendor savedVendor= vendorRepository.save(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateVendor(Vendor vendor,int id) {
        if(!vendorRepository.existsById(id)){
            throw new CustomException("Vendor with given id does not exist.",404);
        }
        vendor.setVendorId(id);
        Vendor updatedVendor= vendorRepository.save(vendor);
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }

    public ResponseEntity<Object> removeVendor(int id) {
        if(!vendorRepository.existsById(id)){
            throw new CustomException("Vendor with given id does not exist.",404);
        }
        vendorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
