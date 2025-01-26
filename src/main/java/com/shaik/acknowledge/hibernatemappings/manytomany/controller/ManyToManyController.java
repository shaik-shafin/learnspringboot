package com.shaik.acknowledge.hibernatemappings.manytomany.controller;

import com.shaik.acknowledge.hibernatemappings.manytomany.domain.Order;
import com.shaik.acknowledge.hibernatemappings.manytomany.domain.Product;
import com.shaik.acknowledge.hibernatemappings.manytomany.service.OrderService;
import com.shaik.acknowledge.hibernatemappings.manytomany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hibernate-mapping/many-to-many")
public class ManyToManyController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("all-orders")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("order/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) { return orderService.getOrderById(orderId); }

    @PostMapping("save-order")
    public String saveOrder(@RequestBody Order order) {

        List<Product> listOfProducts = order.getProduct()
                .stream()
                .map(product -> productService.getProductById(product.getProductId())).toList();

        order.setProduct(listOfProducts);
        orderService.saveOrder(order);
        return "Order saved successfully";
    }

    @DeleteMapping("delete-order/{orderId}")
    public String deleteOrderById(@PathVariable Integer orderId) {

        orderService.deleteOrderById(orderId);
        return "Order deleted successfully";
    }

    @GetMapping("all-products")
    public List<Product> getAllProducts() { return productService.getAllProducts(); }

    @GetMapping("product/{productId}")
    public Product getProductById(@PathVariable Integer productId) { return productService.getProductById(productId); }

    @PostMapping("save-product")
    public String saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);
        return "Product saved successfully";
    }

    @DeleteMapping("delete-product/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {

        productService.deleteProduct(productId);
        return "Product deleted successfully";
    }
}
