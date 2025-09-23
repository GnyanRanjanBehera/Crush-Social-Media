package com.crush.crush_user_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CrushUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrushUserServiceApplication.class, args);
	}

}
