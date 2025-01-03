package com.example.rest.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private String productId;
	private String categoryId;
	private String name;
	private String description;

	public Product(String productId, String categoryId, String name, String description) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId.trim();
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", name=" + name + ", description="
				+ description + "]";
	}
}
