package br.inatel.myrestapi;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.myrestapi.model.Curso;

public class WebClientPostMain {
	public static void main(String[] args) {
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Dominando Spring WebFlux");
		novoCurso.setCargaHoraria(80);
		
		Curso cursoCriado = WebClient.create("localhost:8080/curso")
				.post()
				.bodyValue(novoCurso)
				.retrieve()
				.bodyToMono(Curso.class)
				.block();
		
		System.out.println("Curso criado:");
		System.out.println(cursoCriado);
		
	}
}
