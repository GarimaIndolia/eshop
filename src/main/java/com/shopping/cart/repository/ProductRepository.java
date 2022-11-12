package com.shopping.cart.repository;

import com.shopping.cart.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
