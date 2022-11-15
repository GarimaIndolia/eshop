package com.shopping.cart.service;

import com.shopping.cart.bean.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface UserService {

 Users saveUser(Users users);

 Users updateUser(Users users);

}