package com.example.springbootcrudexample1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEE_TABLE")

public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int deptNo;

    public Employee(String s, int n) {
        name=s;
        deptNo=n;
    }
}
