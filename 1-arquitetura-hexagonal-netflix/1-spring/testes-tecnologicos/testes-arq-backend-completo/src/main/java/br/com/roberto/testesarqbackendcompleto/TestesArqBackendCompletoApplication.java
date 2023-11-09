package br.com.roberto.testesarqbackendcompleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.roberto.testesarqbackendcompleto.*")
public class TestesArqBackendCompletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestesArqBackendCompletoApplication.class, args);
	}

}
