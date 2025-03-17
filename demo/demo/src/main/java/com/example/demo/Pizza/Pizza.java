package com.example.demo.Pizza;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category is required")
    private Category category;

    @Positive(message = "Price must be positive")
    private double price;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Size size;

    private boolean isAvailable = true;

	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pizza(Long id, @NotBlank(message = "Name is required") String name,
			@NotNull(message = "Category is required") Category category,
			@Positive(message = "Price must be positive") double price, String imageUrl, Size size,
			boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.imageUrl = imageUrl;
		this.size = size;
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
    
}



