package com.api.cadastro.funcionario.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.api.cadastro.funcionario.dto.DepartamentoDTO;
import com.api.cadastro.funcionario.entity.Cargo;
import com.api.cadastro.funcionario.entity.Departamento;
import com.api.cadastro.funcionario.service.CargoService;
import com.api.cadastro.funcionario.service.DepartamentoService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Departamento>> listar() {
		
		return ResponseEntity.ok(service.listar());
		
	}
	
	@GetMapping("/dto")
	public ResponseEntity<List<DepartamentoDTO>> listarDTO() {
		List<Departamento> list = service.listar();
		return ResponseEntity.ok(DepartamentoService.listarDTO(list));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
		Departamento cargo = service.buscarPorId(id);
		return ResponseEntity.ok(cargo);
		
	}
	@GetMapping("/dto/{id}")
	public ResponseEntity<DepartamentoDTO> buscarPorIdDTO(@PathVariable Long id) {
		DepartamentoDTO dto = service.buscarPorIdDTO(id);
		return ResponseEntity.ok(dto);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Departamento> cadastrar(@RequestBody @Valid Departamento departamento){
		Departamento retorno = service.cadastrar(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cargo> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
		 
		return ResponseEntity.ok(service.atualizar(id,departamento));
		
	}
	
}
