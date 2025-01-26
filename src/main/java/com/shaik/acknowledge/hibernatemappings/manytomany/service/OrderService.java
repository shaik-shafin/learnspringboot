package com.shaik.acknowledge.hibernatemappings.manytomany.service;

import com.shaik.acknowledge.hibernatemappings.manytomany.domain.Order;
import com.shaik.acknowledge.hibernatemappings.manytomany.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    public Order getOrderById(Integer orderId){
        return orderRepository.getById(orderId);
    }

    public Order saveOrder(Order order) { return orderRepository.save(order); }

    public void deleteOrderById(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
