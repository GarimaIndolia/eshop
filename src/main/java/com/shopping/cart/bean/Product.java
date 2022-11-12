package com.shopping.cart.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column
private long productId;
private String productName;
private String productCategory;
private double productPrice;

}
