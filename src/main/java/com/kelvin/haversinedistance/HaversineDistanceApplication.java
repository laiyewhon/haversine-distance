package com.kelvin.haversinedistance;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Postcode API", version = "0.0.1-SNAPSHOT", description = "This is a Postcode API to retieve, update and calculate distance given 2 uk postcodes"))
public class HaversineDistanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaversineDistanceApplication.class, args);
    }

}
