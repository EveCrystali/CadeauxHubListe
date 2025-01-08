package com.cadeauxhubliste.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cadeauxhubliste")
@EntityScan(basePackages = "com.cadeauxhubliste.model") // Scanne les entités JPA
@EnableJpaRepositories(basePackages = "com.cadeauxhubliste.repository") // Scanne les repositories
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
