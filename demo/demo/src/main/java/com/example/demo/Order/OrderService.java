package com.example.demo.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long userId, Order order);
    List<Order> getUserOrders(Long userId);
	
}


