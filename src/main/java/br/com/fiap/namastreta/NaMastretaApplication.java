package br.com.fiap.namastreta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "br.com.fiap.namastreta.models")
public class NaMastretaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaMastretaApplication.class, args);
	}

}
