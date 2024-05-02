package org.example.controllers;

import org.example.model.Order;
import org.example.model.OrderDetails;
import org.example.repository.OrderDetailsRepository;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.interfaces.EdECKey;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderController(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @PostMapping("/orders")
    public int saveOrder(@RequestBody Order order){
        try {
            Order saved = orderRepository.save(order);
            return saved.getId();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    @PostMapping("/orderDetails")
    public int saveOrderDetails(@RequestBody OrderDetails orderDetails){
        try {
            OrderDetails saved = orderDetailsRepository.save(orderDetails);
            return saved.getId();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    @GetMapping("/orders/{id}")
    public List<Order> getCustomerOrder(@PathVariable int id)
    {
        try {
            return orderRepository.findByCustomerId(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    @GetMapping("/orderDetails/{id}")
    public OrderDetails getDetails(@PathVariable int id){
        try {
            return orderDetailsRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

}
