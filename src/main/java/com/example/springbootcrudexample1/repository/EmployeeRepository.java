package com.example.springbootcrudexample1.repository;

import com.example.springbootcrudexample1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
   // Employee findByName(String name);
}
