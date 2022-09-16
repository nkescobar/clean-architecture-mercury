package com.makingapp.mercury.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercuryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercuryApplication.class, args);
		System.out.println("INIT APPLICATION");
	}

}
