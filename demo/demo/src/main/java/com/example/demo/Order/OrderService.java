package com.example.demo.Order;

import java.util.List;

public interface OrderService {
    Order createPizzaOrder(Order pizzaOrder);
    List<Order> getAllPizzaOrders();
    Order getPizzaOrderById(Long id);
    Order updatePizzaOrder(Long id, Order pizzaOrder);
    void deletePizzaOrder(Long id);
	List<Order> getPastOrdersByCustomer(String customerName);
}


