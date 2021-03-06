package br.inatel.myrestapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.myrestapi.model.Curso;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CursoControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	

	@Test
	void deveListarCursos() {
		webTestClient.get()
		.uri("/curso")
		.exchange()
		.expectStatus().isOk()
		.expectBody().returnResult();
	}
	
	@Test 
	void dadoCursoIdInvalido_quandoGetCursoId_entaoRespondeComStatusNotFound(){
		Long idInvalido = 11L;
		
		webTestClient.get()
		.uri("/curso "+idInvalido)
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test 
	void dadoCursoExistente_quandoPutCurso_entaoRespondeComCursoAtualizado() {
		 
		Curso cursoExistente =  new Curso(1l, "Dominando teste APIs", 80);
		
		webTestClient.put()
		.uri("/curso")
		.bodyValue(cursoExistente)
		.exchange()
		.expectStatus().isOk();
		
		
//								.expectBody(Curso.class)
//									.returnResult()
//									.getResponseBody();
//		
//		assertEquals(cursoExistente.getId(), cursoAtualizado.getId());
//		assertEquals(cursoExistente.getDescricao(), cursoAtualizado.getDescricao());
//		assertEquals(cursoExistente.getCargaHoraria(), cursoAtualizado.getCargaHoraria());
		
	}

}
