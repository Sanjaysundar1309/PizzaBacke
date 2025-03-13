package com.example.demo.Pizza;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/toppings")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;

    @GetMapping
    public ResponseEntity<List<Topping>> getAllToppings() {
        return new ResponseEntity<>(toppingService.getAllToppings(), HttpStatus.OK);
    }
}