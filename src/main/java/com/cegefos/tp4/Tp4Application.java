package com.cegefos.tp4;

import com.cegefos.tp4.repository.ExamenRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class Tp4Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp4Application.class, args);
	}

}
