package com.example.demo.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaToppingRepository extends JpaRepository<PizzaTopping, Long> {
}
