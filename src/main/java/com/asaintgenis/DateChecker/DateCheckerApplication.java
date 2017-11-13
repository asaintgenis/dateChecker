package com.asaintgenis.DateChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class DateCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateCheckerApplication.class, args);
	}
}
