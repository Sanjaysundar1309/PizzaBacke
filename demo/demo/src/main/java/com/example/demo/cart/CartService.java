package com.example.demo.cart;

import java.util.List;

public interface CartService {
    CartItem addToCart(CartItem cartItem);
    List<CartItem> getCartItems(Long userId);
    void removeFromCart(Long userId, Long pizzaId);
}

