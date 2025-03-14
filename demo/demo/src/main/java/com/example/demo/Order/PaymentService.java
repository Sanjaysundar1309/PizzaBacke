package com.example.demo.Order;


import java.util.List;

public interface PaymentService {
    void processPayment(Long orderId);
    List<Payment> getPaymentHistory();
}
