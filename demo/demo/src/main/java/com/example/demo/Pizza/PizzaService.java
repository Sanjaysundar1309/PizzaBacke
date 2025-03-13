package com.example.demo.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza addPizza(Pizza pizza);
    Pizza updatePizza(Long id, Pizza pizza);
    void deletePizza(Long id);
    List<Pizza> getAllPizzas();
    Pizza getPizzaById(Long id);
    List<Pizza> getPizzasByCategoryAndSize(String category, String size);
	List<Pizza> getPizzasByCategory(String category);
    List<Pizza> getPizzasBySize(String size);
}
