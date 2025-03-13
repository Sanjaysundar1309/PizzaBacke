package com.example.demo.Pizza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	List<Pizza> findByCategoryAndSize(String category, String size);

	List<Pizza> findByCategory(String category);

	List<Pizza> findBySize(String size);

	
	
}