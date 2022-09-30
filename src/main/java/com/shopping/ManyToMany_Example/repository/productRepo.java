package com.shopping.ManyToMany_Example.repository;

import com.shopping.ManyToMany_Example.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepo extends JpaRepository<product,Long> {
    List<product> findByPriceLessThan(Double price);
}
