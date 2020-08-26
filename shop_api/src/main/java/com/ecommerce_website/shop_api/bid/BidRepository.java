package com.ecommerce_website.shop_api.bid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BidRepository extends CrudRepository<Bid,Integer> {
    public List<Bid> findByProductProductId(Integer productId);
    public List<Bid> findByVendorVendorId(Integer vendorId);
}
