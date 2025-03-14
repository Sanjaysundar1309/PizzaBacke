package com.example.demo.Payment;


import java.util.List;

public interface PaymentService {
    void processPayment(Long orderId);
    List<Payment> getPaymentHistory();
}
