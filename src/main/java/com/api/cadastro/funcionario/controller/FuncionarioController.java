package com.api.cadastro.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cadastro.funcionario.entity.Funcionario;
import com.api.cadastro.funcionario.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
		
		return ResponseEntity.ok(service.listar());
		
	}
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable(name = "id") Long id) throws Exception {
		
		Funcionario f = service.buscarPorId(id);
	
		return ResponseEntity.ok(f);
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario) {
		
		Funcionario func = service.cadastrar(funcionario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(func);	
		
	}

	@DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable(name = "id") Long id) {
		service.deletar(id);
		
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable(name = "id") Long id, @RequestBody Funcionario funcionario) {
		
		Funcionario func = service.atualizar(id,funcionario);
		return ResponseEntity.ok(func);
		
	}

}
