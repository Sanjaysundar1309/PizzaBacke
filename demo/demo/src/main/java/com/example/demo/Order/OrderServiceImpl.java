package com.example.demo.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository pizzaOrderRepository;

    @Override
    public Order createPizzaOrder(Order pizzaOrder) {
        // Set the order reference in each order item
        pizzaOrder.getOrderItems().forEach(item -> item.setOrder(pizzaOrder));

        // Calculate total amount based on pizza items
        double totalAmount = pizzaOrder.getOrderItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        pizzaOrder.setTotalAmount(totalAmount);

        return pizzaOrderRepository.save(pizzaOrder);
    }

    @Override
    public List<Order> getAllPizzaOrders() {
        return pizzaOrderRepository.findAll();
    }

    @Override
    public Order getPizzaOrderById(Long id) {
        return pizzaOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza Order not found with id: " + id));
    }

    @Override
    public Order updatePizzaOrder(Long id, Order pizzaOrder) {
        Order existingOrder = getPizzaOrderById(id);

        // Update order details
        existingOrder.setCustomerName(pizzaOrder.getCustomerName());
        existingOrder.setDeliveryAddress(pizzaOrder.getDeliveryAddress());
        existingOrder.setOrderDate(pizzaOrder.getOrderDate());
        existingOrder.setStatus(pizzaOrder.getStatus());

        // Update order items
        existingOrder.getOrderItems().clear(); // Clear existing items
        existingOrder.getOrderItems().addAll(pizzaOrder.getOrderItems()); // Add new items
        existingOrder.getOrderItems().forEach(item -> item.setOrder(existingOrder)); // Set order reference

        // Recalculate total amount
        double totalAmount = pizzaOrder.getOrderItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        existingOrder.setTotalAmount(totalAmount);

        return pizzaOrderRepository.save(existingOrder);
    }

    @Override
    public void deletePizzaOrder(Long id) {
        pizzaOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> getPastOrdersByCustomer(String customerName) {
        return pizzaOrderRepository.findByCustomerName(customerName);
    }
}