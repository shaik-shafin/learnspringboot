package com.shaik.acknowledge.L2cache.controller;

import com.shaik.acknowledge.L2cache.domain.OrderDetails;
import com.shaik.acknowledge.L2cache.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l2-cache")
public class HomeController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("fetch-orders")
    public List<OrderDetails> getRequest(){

        return orderDetailsService.getAllOrderDetails();
    }

    @PostMapping("save")
    public String postRequest(@RequestBody OrderDetails orderDetails){

        orderDetailsService.saveOrder(orderDetails);
        return "user saved successfully.";
    }

    @GetMapping("order/{orderId}")
    public OrderDetails getRequest(@PathVariable Integer orderId){
        return orderDetailsService.getOrderDetails(orderId);
    }

    @PutMapping("update-order")
    public OrderDetails putRequest(@RequestBody OrderDetails orderDetails){
        return orderDetailsService.updateOrder(orderDetails);
    }

    @DeleteMapping("delete-order/{orderId}")
    public void deleteRequest(@PathVariable Integer orderId){
        orderDetailsService.deleteOrder(orderId);
    }
}
