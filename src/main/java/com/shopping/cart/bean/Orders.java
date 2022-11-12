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

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long orderId;

	private LocalDateTime orderDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", nullable = false)
	private Product productId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	private Product userId;
	
	private String orderStatus;

}
