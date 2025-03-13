package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository pizzaOrderRepository;

    @Override
    public Order createPizzaOrder(Order pizzaOrder) {
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
                .orElseThrow(() -> new RuntimeException("Pizza Order not found"));
    }

    @Override
    public Order updatePizzaOrder(Long id, Order pizzaOrder) {
        Order existingOrder = getPizzaOrderById(id);
        existingOrder.setCustomerName(pizzaOrder.getCustomerName());
        existingOrder.setDeliveryAddress(pizzaOrder.getDeliveryAddress());
        existingOrder.setOrderDate(pizzaOrder.getOrderDate());

        // Recalculate total amount
        double totalAmount = ((Collection<OrderItem>) pizzaOrder.getOrderDate()).stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        existingOrder.setTotalAmount(pizzaOrder.getTotalAmount());

        return pizzaOrderRepository.save(existingOrder);
    }

    @Override
    public void deletePizzaOrder(Long id) {
        pizzaOrderRepository.deleteById(id);
    }

	@Override
	public List<Order> getPastOrdersByCustomer(String customerName) {
		// TODO Auto-generated method stub
		return pizzaOrderRepository.findByCustomerName(customerName);
	}
}