package com.shopping.cart.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
