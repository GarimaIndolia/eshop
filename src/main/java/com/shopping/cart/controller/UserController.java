package com.shopping.cart.controller;

import com.shopping.cart.bean.User;
import com.shopping.cart.constant.Constant;
import com.shopping.cart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @PostMapping(value = Constant.CREATE_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user)  {
        return new ResponseEntity(userService.saveUser(user).getUserId(), HttpStatus.CREATED);
    }

    @PutMapping(value = Constant.UPDATE_USER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user)  {
        return new ResponseEntity(userService.updateUser(user).getUserId(), HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
        return new ResponseEntity("Internal Server Error has occurred... "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
