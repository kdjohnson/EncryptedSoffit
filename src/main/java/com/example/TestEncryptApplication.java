package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apereo.portal.soffit.renderer.SoffitApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("com.example")
@SoffitApplication
@SpringBootApplication
public class TestEncryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEncryptApplication.class, args);
	}
}
