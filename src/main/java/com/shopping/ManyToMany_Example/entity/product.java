package com.shopping.ManyToMany_Example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
//@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence",initialValue = 1,allocationSize = 10)
@Table(name = "PRODUCT_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    long id;
    String name;
    double price;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
    private Set<customer> customers;
}
