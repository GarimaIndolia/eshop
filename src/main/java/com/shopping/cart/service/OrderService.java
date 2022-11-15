package com.shopping.cart.service;

import com.shopping.cart.bean.Orders;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderService {

    public long createOrder(Orders order);

    public Orders updateOrder(Orders order);

    public List findAllOrdersByConditions(LocalDateTime dateMin, LocalDateTime dateMax);

    public List getOrderById(Long orderId);
}
