package com.shopping.cart.service.impl;

import com.shopping.cart.bean.Orders;
import com.shopping.cart.bean.OrderRecordAccessSpecification;
import com.shopping.cart.repository.OrderRecordAccessRepository;
import com.shopping.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRecordAccessRepository orderRepository;

    @Override
    public long createOrder(Orders order) {
        return orderRepository.save(order).getId();
    }

    @Override
    public Orders updateOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public List findAllOrdersByConditions(LocalDateTime dateMin, LocalDateTime dateMax) {
        Specification<Orders> spec = new OrderRecordAccessSpecification(new Orders(), dateMin, dateMax);
        return orderRepository.findAll(spec);
    }

    @Override
    public Orders getOrdersById(Long id) {
        return orderRepository.findById(id).get();
    }

}
