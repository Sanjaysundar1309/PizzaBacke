package com.example.demo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
    void deleteByUserIdAndPizzaId(Long userId, Long pizzaId);
}
