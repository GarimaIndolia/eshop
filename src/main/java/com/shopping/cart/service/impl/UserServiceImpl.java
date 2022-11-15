package com.shopping.cart.service.impl;

import com.shopping.cart.bean.Users;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        return userRepository.save(users);
    }
}
