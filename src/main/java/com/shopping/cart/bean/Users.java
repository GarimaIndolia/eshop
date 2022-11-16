package com.shopping.cart.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column
private long userId;
private String userName;
private String userPassword;
private String phoneNum;
private String email;

}
