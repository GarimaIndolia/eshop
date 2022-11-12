package com.shopping.cart.service;

import com.shopping.cart.bean.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    public long createOrder(Order order);

    public Order updateOrder(Order order);

    public List findAllOrdersByConditions(LocalDateTime dateMin, LocalDateTime dateMax);

    public Order getOrderById(Long orderId);
}
