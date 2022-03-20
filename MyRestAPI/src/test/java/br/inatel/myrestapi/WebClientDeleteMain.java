package br.inatel.myrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientDeleteMain {
	public static void main(String[] args) {
		
		ResponseEntity<Void> responseEntity = WebClient.create("localhost:8080/curso/3")
				.delete()
				.retrieve()
				.toBodilessEntity()
				.block();
		
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		System.out.println("Cueso atualizado. Status: "+statusCode);
	}
}
