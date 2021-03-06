package br.inatel.myrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.myrestapi.model.Curso;
import br.inatel.myrestapi.service.CursoService;

@RestController
@RequestMapping("/curso")

public class CursoController {
	
	@Autowired
	private CursoService servico;
	
	@GetMapping
	public List<Curso> listar(){
		List<Curso> listaCurso = servico.pesquisarCurso();
		return listaCurso;
	}
	
	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Long cursoId) {
		Curso curso = servico.buscarCursoPeloId(cursoId);
		if(curso !=null) {
			return curso;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso Criar(@RequestBody Curso curso) {
		curso = servico.criarCurso(curso);
		return curso;
	}
	
// @RequestBody
	
	@PutMapping
	public void atualizar(@RequestBody Curso curso) {
		servico.atualizarCurso(curso);
	}
	
	@DeleteMapping("{id}")
	public void remove(@PathVariable("id") Long cursoIdRemover) {
		servico.removerCurso(cursoIdRemover);
	}

}
