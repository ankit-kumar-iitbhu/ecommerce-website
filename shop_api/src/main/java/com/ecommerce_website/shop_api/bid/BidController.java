package com.ecommerce_website.shop_api.bid;

import com.ecommerce_website.shop_api.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {

    @Autowired
    private BidService bidService;

    private static final String baseUrl=Constants.bidUrl;

    //admin
    @RequestMapping(value=baseUrl)
    public ResponseEntity<Object> getAllBids(){ return bidService.getAllBid(); }

    //public
    @RequestMapping(value=baseUrl+"/{id}")
    public ResponseEntity<Object> getBid(@PathVariable("id") Integer bidId){
        return bidService.getBid(bidId);
    }


    //public
    @RequestMapping(value=baseUrl+"/searchByProduct")
    public ResponseEntity<Object> getBidsByProduct(@RequestParam("productId") Integer productId){
        return bidService.getBidByProductId(productId);
    }
    //vendor
    @RequestMapping(value=baseUrl+"/searchByVendor")
    public ResponseEntity<Object> getBidsByVendor(@RequestParam("vendorId") Integer vendorId){
        return bidService.getBidByVendorId(vendorId);
    }

    //vendor
    @RequestMapping(value=baseUrl,method= RequestMethod.POST)
    public ResponseEntity<Object> postBid(@RequestBody BidDTO bidDTO){
        return bidService.addBid(bidDTO);
    }


}
