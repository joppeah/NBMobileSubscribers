package com.java.subscribers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SubscribersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscribersApplication.class, args);
	}
}
