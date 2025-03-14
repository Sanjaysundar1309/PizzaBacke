package com.example.demo.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestParam Long orderId) {
        paymentService.processPayment(orderId);
        return ResponseEntity.ok("Payment processed successfully!");
    }

    @GetMapping("/history")
    public ResponseEntity<List<Payment>> getPaymentHistory() {
        List<Payment> paymentHistory = paymentService.getPaymentHistory();
        return ResponseEntity.ok(paymentHistory);
    }
}
