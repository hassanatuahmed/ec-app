package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    @CacheEvict(value = "carts", allEntries = true)
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @CacheEvict(value = "carts", allEntries = true)
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
}