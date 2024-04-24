package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@MapperScan("com.example.demo.domain.mapper")
public class DmsTraining1Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DmsTraining1Application.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("index.html");
	}

}
