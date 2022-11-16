package com.shopping.cart.controller;

import com.shopping.cart.bean.Orders;
import com.shopping.cart.constant.Constant;
import com.shopping.cart.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class OrderController {

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @GetMapping(value = Constant.GET_ORDER_HISTORY,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderHistory(@RequestParam(value="fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromDate, @RequestParam(value="toDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime toDate)  {
        return new ResponseEntity(orderService.findAllOrdersByConditions(fromDate, toDate), HttpStatus.OK);
    }

    @GetMapping(value = Constant.GET_ORDER_DETAIL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderDetails(@RequestParam(value="orderId") Long orderId)  {
        return new ResponseEntity(orderService.getOrdersById(orderId), HttpStatus.OK);
    }

    @PostMapping(value = Constant.PLACE_ORDER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity placeOrder(@RequestBody Orders order)  {
        return new ResponseEntity(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping(value = Constant.CANCEL_ORDER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cancelOrder(@RequestParam(value="id") Long id)  {
        Orders order= orderService.getOrdersById(id);
        order.setOrderStatus("Cancelled");
        return new ResponseEntity(orderService.updateOrder(order).getId(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
        return new ResponseEntity("Internal Server Error has occurred... "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
