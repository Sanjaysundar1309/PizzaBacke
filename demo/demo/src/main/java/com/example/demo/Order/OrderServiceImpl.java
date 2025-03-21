package com.example.demo.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order placeOrder(Long userId, Order order) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);
        Order savedOrder = orderRepository.save(order);

        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(savedOrder);
        }

        orderItemRepository.saveAll(order.getOrderItems());

        return savedOrder;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
