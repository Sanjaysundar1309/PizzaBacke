package com.example.demo.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService pizzaOrderService;

    @PostMapping
    public Order createPizzaOrder(@RequestBody Order pizzaOrder) {
        return pizzaOrderService.createPizzaOrder(pizzaOrder);
    }

    @GetMapping
    public List<Order> getAllPizzaOrders() {
        return pizzaOrderService.getAllPizzaOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getPizzaOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaOrderService.getPizzaOrderById(id));
    }

    @PutMapping("/{id}")
    public Order updatePizzaOrder(@PathVariable Long id, @RequestBody Order pizzaOrder) {
        return pizzaOrderService.updatePizzaOrder(id, pizzaOrder);
    }

    @DeleteMapping("/{id}")
    public void deletePizzaOrder(@PathVariable Long id) {
        pizzaOrderService.deletePizzaOrder(id);
    }
    @GetMapping("/past")
    public ResponseEntity<List<Order>> getPastOrdersByCustomer(@RequestParam String customerName) {
        List<Order> pastOrders = pizzaOrderService.getPastOrdersByCustomer(customerName);
        return ResponseEntity.ok(pastOrders);
    }
}
  
