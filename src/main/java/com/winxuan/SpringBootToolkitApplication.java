package com.winxuan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config-toolkit-simple.xml")
public class SpringBootToolkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToolkitApplication.class, args);
	}
}
