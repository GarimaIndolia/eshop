package com.shopping.cart.service.impl;

import com.shopping.cart.bean.Order;
import com.shopping.cart.bean.OrderRecordAccessSpecification;
import com.shopping.cart.repository.OrderRecordAccessRepository;
import com.shopping.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRecordAccessRepository orderRepository;

    @Override
    public long createOrder(Order order) {
        return orderRepository.save(order).getOrderId();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List findAllOrdersByConditions(LocalDateTime dateMin, LocalDateTime dateMax) {
        Specification<Order> spec = new OrderRecordAccessSpecification(new Order(), dateMin, dateMax);
        return orderRepository.findAll(spec);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}
