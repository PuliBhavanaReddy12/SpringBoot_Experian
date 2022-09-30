package com.shopping.ManyToMany_Example.service;

import com.shopping.ManyToMany_Example.entity.customer;
import com.shopping.ManyToMany_Example.repository.customerRepo;
import com.shopping.ManyToMany_Example.repository.productRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {
    customerService(){
        System.out.println("customer service custructor called");
    }

    @Autowired
    private customerRepo cr;

    //create
    public customer saveCustomer(customer c){
        return cr.save(c);
    }
    //retrieve
    public List<customer> getAllCustomers(){
        return cr.findAll();
    }
    public customer getCustomerById(long id){
        return cr.findById(id).orElse(null);
    }
    public List<customer> getCustomerContainingName(String name){
        return cr.findByNameContaining(name);
    }
    //update
    public customer updateCustomer(customer c){
        customer ec=cr.findById(c.getId()).orElse(null);
        BeanUtils.copyProperties(c,ec,"id");
        return cr.saveAndFlush(ec);
    }
    //delete
    public String deleteCustomer(long id){
        cr.deleteById(id);
        return "customer deleted with id "+id;
    }

}
