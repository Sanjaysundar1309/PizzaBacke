package com.example.demo.Payment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void processPayment(Long orderId) {
        // Simulate payment processing
        Payment payment = new Payment(orderId, "Success", LocalDateTime.now());
        paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentHistory() {
        return paymentRepository.findAll();
    }
}
