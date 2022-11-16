package com.shopping.cart.repository;

import java.util.List;

import com.shopping.cart.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRecordAccessRepository extends JpaRepository<Orders,Long >, JpaSpecificationExecutor<Orders>{

	List<Orders> findByOrderDate(Orders o);

}
