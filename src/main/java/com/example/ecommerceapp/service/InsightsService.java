package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Order;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.repository.OrderRepository;
import com.example.ecommerceapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsightsService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Cacheable("insights")
    public Map<String, Object> getInsights() {
        Map<String, Object> result = new HashMap<>();

        result.put("totalProducts", productRepo.count());

        List<Order> orders = orderRepo.findAll();
        result.put("totalOrders", orders.size());

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
        result.put("totalRevenue", totalRevenue);

        Map<String, Long> productFrequency = new HashMap<>();

        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                productFrequency.merge(product.getName(), 1L, Long::sum);
            }
        }

        List<Map.Entry<String, Long>> topProducts = productFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .toList();

        result.put("topProducts", topProducts);

        return result;
    }
}
