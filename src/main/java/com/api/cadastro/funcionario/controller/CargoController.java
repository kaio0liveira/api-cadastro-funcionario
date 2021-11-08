package com.api.cadastro.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.api.cadastro.funcionario.entity.Cargo;
import com.api.cadastro.funcionario.service.CargoService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	CargoService service;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> listar() {
		
		return ResponseEntity.ok(service.listar());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> buscarPorId(@PathVariable Long id) {
		Cargo cargo = service.buscarPorId(id);
		return ResponseEntity.ok(cargo);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Cargo> cadastrar(@RequestBody Cargo cargo){
		Cargo retorno = service.cadastrar(cargo);
		return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cargo> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody Cargo cargo) {
		 
		return ResponseEntity.ok(service.atualizar(id,cargo));
		
	}
	
}
