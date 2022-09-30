package com.shopping.ManyToMany_Example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
//@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence", initialValue = 1,allocationSize = 10)
@Table(name = "CUSTOMER_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about customer")
public class customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
            @ApiModelProperty(notes = "unique id of customer")
    long id;
    String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_PRODUCT_TABLE",
    joinColumns = {
            @JoinColumn(name="customer_id",referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name="product_id",referencedColumnName = "id")
            }
    )
    private Set<product> products;
}
