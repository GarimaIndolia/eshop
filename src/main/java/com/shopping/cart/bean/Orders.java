package com.shopping.cart.bean;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;


	private LocalDateTime orderDate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "productId")
	private Product productId;

	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Users.class)
	@JoinColumn(name = "userId")
	private Users userId;
	
	private String orderStatus;

}
