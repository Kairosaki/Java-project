package com.exercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfig.class})
public class SimpleDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDatabaseApplication.class, args);
	}
}
