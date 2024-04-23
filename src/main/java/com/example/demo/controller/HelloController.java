package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Hello;

@RestController
@RequestMapping("/api")

public class HelloController {

	@GetMapping("/hello")
	public Hello hello() {
	return new Hello();
	}

}
