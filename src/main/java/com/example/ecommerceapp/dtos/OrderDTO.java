package com.example.ecommerceapp.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private List<ProductDTO> products;
    private Double totalPrice;
    private LocalDateTime createdAt;
}

