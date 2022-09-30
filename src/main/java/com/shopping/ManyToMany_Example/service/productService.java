package com.shopping.ManyToMany_Example.service;

import com.shopping.ManyToMany_Example.entity.product;
import com.shopping.ManyToMany_Example.repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepo pr;

    public List<product> findProductLessThanPrice(double price){
        return pr.findByPriceLessThan(price);
    }
}
