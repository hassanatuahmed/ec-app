package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Order;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.repository.OrderRepository;
import com.example.ecommerceapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @CacheEvict(value = "orders", allEntries = true)

    public Order placeOrder(List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);

        if (products.isEmpty()) {
            throw new RuntimeException("No valid products found");
        }

        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        Order order = new Order();
        order.setProducts(products);
        order.setTotalPrice(totalPrice);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }
    @CacheEvict(value = "orders", allEntries = true)

    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    @CacheEvict(value = "orders", allEntries = true)

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
