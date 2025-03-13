package com.example.demo.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
    @Override
    public Pizza updatePizza(Long id, Pizza pizza) {
        Pizza existingPizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException("Pizza not found with id: " + id));
        existingPizza.setName(pizza.getName());
        existingPizza.setCategory(pizza.getCategory());
        existingPizza.setPrice(pizza.getPrice());
        existingPizza.setImageUrl(pizza.getImageUrl());
        existingPizza.setSize(pizza.getSize());
        existingPizza.setAvailable(pizza.isAvailable());
        return pizzaRepository.save(existingPizza);
    }

    @Override
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException("Pizza not found with id: " + id));
    }
    @Override
    public List<Pizza> getPizzasByCategoryAndSize(String category, String size) {
        return pizzaRepository.findByCategoryAndSize(category, size);
    }
    @Override
    public List<Pizza> getPizzasByCategory(String category) {
        return pizzaRepository.findByCategory(category);
    }

    @Override
    public List<Pizza> getPizzasBySize(String size) {
        return pizzaRepository.findBySize(size);
    }

}