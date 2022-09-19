package com.makingapp.mercury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.makingapp.mercury",
        "com.makingapp.mercury.usecase","com.makingapp.mercury.*"}
)
@ConfigurationPropertiesScan(basePackages = {"com.makingapp.mercury",
        "com.makingapp.mercury.usecase" , "com.makingapp.mercury.*"})
public class MercuryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuryApplication.class, args);
        System.out.println("INIT APPLICATION");
    }

}
