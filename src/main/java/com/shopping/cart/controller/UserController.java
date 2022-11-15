package com.shopping.cart.controller;

import com.shopping.cart.bean.Users;
import com.shopping.cart.constant.Constant;
import com.shopping.cart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping(value = Constant.CREATE_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody Users users)  {
        return new ResponseEntity(userService.saveUser(users).getUserId(), HttpStatus.CREATED);
    }

    @PutMapping(value = Constant.UPDATE_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody Users users)  {
        return new ResponseEntity(userService.updateUser(users).getUserId(), HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
        return new ResponseEntity("Internal Server Error has occurred... "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
