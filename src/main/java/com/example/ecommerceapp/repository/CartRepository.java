package com.example.ecommerceapp.repository;

import com.example.ecommerceapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}