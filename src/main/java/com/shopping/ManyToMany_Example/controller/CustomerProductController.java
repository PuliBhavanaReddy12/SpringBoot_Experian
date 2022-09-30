package com.shopping.ManyToMany_Example.controller;

import com.shopping.ManyToMany_Example.entity.customer;
import com.shopping.ManyToMany_Example.entity.product;
import com.shopping.ManyToMany_Example.service.customerService;
import com.shopping.ManyToMany_Example.service.productService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/product")
public class CustomerProductController {
    @Autowired
    private customerService cs;
    @Autowired
    private productService ps;
//customer
    @PostMapping("/addCustomer")
    public customer addCustomer(@RequestBody customer c){
        return cs.saveCustomer(c);
    }

    @GetMapping
    public List<customer> findAllCustomers(){
        return cs.getAllCustomers();
    }
    @GetMapping("/IdCustomer/{id}")
    @ApiOperation(value = "Finds customer by Id",
    notes = "Provide an id to look up specific contact from the address book",
    response = customer.class)
    public customer findCustomerById(@ApiParam(value = "Id for the customer you need to retrieve",required = true)
            @PathVariable long id){
        return cs.getCustomerById(id);
    }
    @GetMapping("/NameCustomer/{name}")
    public List<customer> findCustomerByName(@PathVariable String name){
        return cs.getCustomerContainingName(name);
    }

    @PutMapping("/updateCustomer")
    public customer updateCustomer(@RequestBody customer c){
        return cs.updateCustomer(c);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable long id){
        return cs.deleteCustomer(id);
    }

//product
    @GetMapping("/findProduct/{price}")
    public List<product> findProductLessThanPrice(@PathVariable double price){
        return ps.findProductLessThanPrice(price);
    }
}
