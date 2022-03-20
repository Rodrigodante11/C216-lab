package br.inatel.myrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.myrestapi.model.Curso;

public class WebClientPutMain {
	public static void main(String[] args) {
		Curso cursoExistente = new Curso(1l, "Rest com spring Boot e Spring WebFlux", 120);
		
		ResponseEntity<Void> responseEntity = WebClient.create("localhost:8080/curso")
				.put()
				.bodyValue(cursoExistente)
				.retrieve()
				.toBodilessEntity()
				.block();
		
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		System.out.println("Cueso atualizado. Status: "+statusCode);
	}
	
}
