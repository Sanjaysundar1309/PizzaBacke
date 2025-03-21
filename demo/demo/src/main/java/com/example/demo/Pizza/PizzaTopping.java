package com.example.demo.Pizza;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="pizza_topping")
public class PizzaTopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "topping_id", nullable = false)
    private Topping topping;
}