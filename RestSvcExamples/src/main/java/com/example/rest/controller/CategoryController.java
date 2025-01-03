package com.example.rest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.rest.domain.Category;
import com.example.rest.domain.Product;

@RestController
public class CategoryController {

	private Map<String, Category> categoryMap = new HashMap<>();
	private Map<String, Product> productMap = new HashMap<>();

	public CategoryController() {
		categoryMap.put("101", new Category("101", "Turtle", "거북이"));
		categoryMap.put("102", new Category("102", "Hedgehog", "고슴도치"));
		productMap.put("PT", new Product("PT", "101", "Painted Turtle", "페인티드 터틀"));
	}

	@GetMapping(value="/category/{categoryId}", produces="application/json")
	//@ResponseBody
	public Category getCategory(@PathVariable("categoryId") String catId, HttpServletResponse response)
			throws IOException {
		Category category = categoryMap.get(catId);
		System.out.println(category);
		if (category == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return category;
	}

	@PostMapping(value="/category", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCategory(@RequestBody Category category, HttpServletResponse response) {
		categoryMap.put(category.getCategoryId(), category);
		UriComponents uriComp = UriComponentsBuilder
									.newInstance()
									.scheme("http")
									.host("localhost")
									.port(8080)
									.path("/category/{categoryId}")
									.build();
		UriComponents encodedUriComp = uriComp.expand(category.getCategoryId()).encode();
		response.setHeader("Location", encodedUriComp.toUriString());
		System.out.println("category " + category.getCategoryId() + " created.");
	}

	@PutMapping(value="/category/{categoryId}", consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@PathVariable("categoryId") String catId, 
			@RequestBody Category category, HttpServletResponse response) throws IOException {
		if (categoryMap.get(catId) == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		categoryMap.put(catId, category);
		System.out.println("category " + catId + " updated.");
	}

	@DeleteMapping(value="/category/{categoryId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Category deleteCategory(@PathVariable("categoryId") String catId, HttpServletResponse response)
			throws IOException {
		Category category = categoryMap.remove(catId);
		if (category == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		System.out.println("category " + category.getCategoryId() + " deleted.");
		return category;
	}

	@GetMapping(value="/category/{categoryId}/product/{productId}")
	@ResponseBody
	public Product getProduct(@PathVariable("categoryId") String catId, 
			@PathVariable("productId") String prodId,
			HttpServletResponse response) throws IOException {
		Product product = productMap.get(prodId);
		if (product == null || !product.getCategoryId().equals(catId)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return product;
	}
}
