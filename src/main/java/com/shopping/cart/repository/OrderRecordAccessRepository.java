package com.shopping.cart.repository;

import java.util.List;

import com.shopping.cart.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OrderRecordAccessRepository extends JpaRepository<Order,Long >, JpaSpecificationExecutor<Order>{

	List<Order> findByOrderDateDesc(Order o);
}
