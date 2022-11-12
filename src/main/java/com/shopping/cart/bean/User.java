package com.shopping.cart.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column
private long userId;
private String userName;
private String userPassword;
private String phoneNum;
private String email;

}
