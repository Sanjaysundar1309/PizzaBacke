package com.example.demo.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizzas")
public class CustomerPizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String size) {
        if (category != null && size != null) {
            // Fetch pizzas by category and size
            return new ResponseEntity<>(pizzaService.getPizzasByCategoryAndSize(category, size), HttpStatus.OK);
        } else if (category != null) {
            // Fetch pizzas by category only
            return new ResponseEntity<>(pizzaService.getPizzasByCategory(category), HttpStatus.OK);
        } else if (size != null) {
            // Fetch pizzas by size only
            return new ResponseEntity<>(pizzaService.getPizzasBySize(size), HttpStatus.OK);
        } else {
            // Fetch all pizzas
            return new ResponseEntity<>(pizzaService.getAllPizzas(), HttpStatus.OK);
        }
    }
}