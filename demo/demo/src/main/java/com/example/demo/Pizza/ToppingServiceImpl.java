package com.example.demo.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    public List<Topping> getAllToppings() {
        return toppingRepository.findAll();
    }
}