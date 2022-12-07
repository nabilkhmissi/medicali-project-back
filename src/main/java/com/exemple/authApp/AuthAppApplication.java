package com.exemple.authApp;

import com.exemple.authApp.entity.User;
import com.exemple.authApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class AuthAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthAppApplication.class, args);
	}

}

