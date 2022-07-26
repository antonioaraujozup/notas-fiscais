package br.com.zup.edu.commerce.notasfiscais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableKafka
@EnableAsync
public class NotasFiscaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotasFiscaisApplication.class, args);
	}

}
