package com.example.ecommerceapp.test;

import com.example.ecommerceapp.model.Order;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.repository.OrderRepository;
import com.example.ecommerceapp.repository.ProductRepository;
import com.example.ecommerceapp.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {


    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testPlaceOrder_success() {
//        // Arrange
//        Product p1 = new Product(1L, "Laptop", "Description", 1000.0, 10);
//        Product p2 = new Product(2L, "Mouse", "Description", 50.0, 5);
//        List<Product> products = List.of(p1, p2);
//
//        when(productRepository.findAllById((Iterable<Long>) any(Collection.class))).thenReturn(products);
//
//
//
//        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
//
//        when(orderRepository.save(orderCaptor.capture()))
//                .thenAnswer(invocation -> (Order) invocation.getArgument(0));
//
//        // Act
//        Order order = orderService.placeOrder(List.of(1L, 2L));
//
//        // Assert
//        assertEquals(1050.0, order.getTotalPrice(), 0.01);
//        assertEquals(2, order.getProducts().size());
//        verify(orderRepository).save(orderCaptor.getValue());
//
//        // Verify captured order object
//        Order capturedOrder = orderCaptor.getValue();
//        assertNotNull(capturedOrder);
//        assertEquals(1050.0, capturedOrder.getTotalPrice(), 0.01);
//        assertEquals(2, capturedOrder.getProducts().size());
//    }

//    @Test
//    public void testPlaceOrder_noProductsFound() {
//        when(productRepository.findAllById(anyList())).thenReturn(Collections.emptyList());
//
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () ->
//                orderService.placeOrder(List.of(99L)));
//
//        assertEquals("No valid products found for the provided IDs", exception.getMessage());
//    }
}