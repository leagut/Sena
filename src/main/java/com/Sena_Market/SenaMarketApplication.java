package com.Sena_Market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = {"com.Sena_Market.persistence.mapper"})
@SpringBootApplication()
public class SenaMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenaMarketApplication.class, args);
	}

}
