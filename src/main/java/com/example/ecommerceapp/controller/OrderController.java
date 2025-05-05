package com.example.ecommerceapp.controller;


import com.example.ecommerceapp.model.Order;
import com.example.ecommerceapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> placeOrder(@RequestBody Map<String, List<Long>> request) {
        List<Long> productIds = request.get("productIds");
        Order placedOrder = orderService.placeOrder(productIds);
        return ResponseEntity.ok(placedOrder);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
