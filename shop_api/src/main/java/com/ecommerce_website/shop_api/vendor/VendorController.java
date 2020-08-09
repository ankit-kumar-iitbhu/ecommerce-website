package com.ecommerce_website.shop_api.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    //admin access
    @RequestMapping("/vendors")
    public ResponseEntity<Object> getVendors(){
        return vendorService.getAllVendor();
    }

    //admin access
    @RequestMapping("/vendors/{id}")
    public ResponseEntity<Object> getVendor(@PathVariable("id") int id) {
        return vendorService.getVendor(id);
    }

    //admin access
    @RequestMapping(value="/vendors",method=RequestMethod.POST)
    public ResponseEntity<Object> addVendor(@RequestBody Vendor temp) {
        return vendorService.addVendor(temp);
    }

    //admin access
    @RequestMapping(value="/vendors/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Object> updateVendor(@RequestBody Vendor temp,@PathVariable("id") int id){
        return vendorService.updateVendor(temp,id);
    }

    //admin access
    @RequestMapping(value="/vendors/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> removeVendor(@PathVariable("id") int id){
        return vendorService.removeVendor(id);
    }


}

