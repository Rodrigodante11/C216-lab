package br.inatel.myrestapi;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.myrestapi.model.Curso;
import reactor.core.publisher.Mono;
public class WebClientMonoMain {

	public static void main(String[] args) {

		try {	
			Mono<Curso> monoCurso = WebClient.create("localhost:8080/curso/2")
									.get()
									.retrieve()
									.bodyToMono(Curso.class);
					
			monoCurso.subscribe();
			Curso curso = monoCurso.block();
					
			System.out.println("Lista Encontrado: ");
			System.out.println( curso);
		
		}catch(WebClientResponseException e) {
	
			System.out.println("Status Code: " +e.getStatusCode());
		
		}
	}

}
