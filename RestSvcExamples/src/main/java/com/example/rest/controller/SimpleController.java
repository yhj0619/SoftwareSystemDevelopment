package com.example.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	@GetMapping
	public String form() {
		return "simpleForm";
	}
	
	@PostMapping
	@ResponseBody
	public String submit(@RequestBody String body) {
		System.out.println("Request Body: " + body);
		return body;
	}
}