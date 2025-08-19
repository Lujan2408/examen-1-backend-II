package com.example.Examen1Back2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.Examen1Back2.modelos")
public class Examen1Back2Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen1Back2Application.class, args);
	}

}
