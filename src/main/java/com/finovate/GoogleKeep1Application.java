package com.finovate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@Slf4j
public class GoogleKeep1Application {

	public static void main(String[] args) {
		SpringApplication.run(GoogleKeep1Application.class, args);
		System.out.println("hello bhushna");
	}

}
