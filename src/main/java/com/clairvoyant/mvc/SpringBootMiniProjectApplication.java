package com.clairvoyant.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.clairvoyant.mvc.configuration.JpaCnfiguration;
@Import(JpaCnfiguration.class)
@SpringBootApplication
@ComponentScan("com.clairvoyant.mvc")
public class SpringBootMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMiniProjectApplication.class, args);
	}
}
