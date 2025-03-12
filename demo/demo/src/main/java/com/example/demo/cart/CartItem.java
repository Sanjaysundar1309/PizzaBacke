package com.example.demo.cart;



import jakarta.persistence.*;
import jakarta.validation.constraints.Min;



@Entity
@Table(name = "cart_items")

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long pizzaId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

	public CartItem() {
		super();
	}

	public CartItem(Long id, Long userId, Long pizzaId,
			@Min(value = 1, message = "Quantity must be at least 1") int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.pizzaId = pizzaId;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
