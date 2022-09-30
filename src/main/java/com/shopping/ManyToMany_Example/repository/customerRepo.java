package com.shopping.ManyToMany_Example.repository;

import com.shopping.ManyToMany_Example.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface customerRepo extends JpaRepository<customer,Long> {
    List<customer> findByNameContaining(String name);
}
