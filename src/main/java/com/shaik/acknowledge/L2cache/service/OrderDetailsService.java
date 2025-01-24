package com.shaik.acknowledge.L2cache.service;

import com.shaik.acknowledge.L2cache.domain.OrderDetails;
import com.shaik.acknowledge.L2cache.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public void saveOrder(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderDetails(Integer orderId) {
        return orderDetailsRepository.findById(orderId).orElse(null);
    }

    public OrderDetails updateOrder(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public void deleteOrder(Integer orderId) {
        orderDetailsRepository.deleteById(orderId);
    }
}
