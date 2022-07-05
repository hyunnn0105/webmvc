package com.spring.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.spring.webmvc")
public class WebmvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebmvcApplication.class, args);
	}

}
