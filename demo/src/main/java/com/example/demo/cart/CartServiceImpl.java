package com.example.demo.cart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem addToCart(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void removeFromCart(Long userId, Long pizzaId) {
        cartRepository.deleteByUserIdAndPizzaId(userId, pizzaId);
    }
}
