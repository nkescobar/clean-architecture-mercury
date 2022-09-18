package com.makingapp.mercury.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.makingapp.mercury")

public class MercuryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercuryApplication.class, args);
		System.out.println("INIT APPLICATION");
	}

}
