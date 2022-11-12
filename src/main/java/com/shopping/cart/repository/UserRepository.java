package com.shopping.cart.repository;

import com.shopping.cart.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long >{
	
}
