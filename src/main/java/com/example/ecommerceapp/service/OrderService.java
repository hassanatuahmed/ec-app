package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Order;
import com.example.ecommerceapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @CacheEvict(value = "orders", allEntries = true)
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @CacheEvict(value = "orders", allEntries = true)
    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
