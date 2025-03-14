package com.example.demo.payment;


import java.util.List;

public interface PaymentService {
    void processPayment(Long orderId);
    List<Payment> getPaymentHistory();
}