package com.api.cadastro.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.funcionario.entity.Cargo;
import com.api.cadastro.funcionario.entity.Departamento;
import com.api.cadastro.funcionario.exception.NotFoundIdException;
import com.api.cadastro.funcionario.repository.CargoRepository;
import com.api.cadastro.funcionario.repository.DepartamentoRepository;


@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository repository;
	
	public List<Departamento> listar() {
		List<Departamento> departamentos = repository.findAll();
		return departamentos;
	}
	
	public Departamento cadastrar(Departamento departamento) {
		
		return repository.save(departamento);
		
	}

	public Departamento buscarPorId(Long id)  {
		this.validarId(id);
		
		return repository.findById(id).get();
		
	}
	
	public void deletar(Long id) {
		this.validarId(id);
		repository.deleteById(id);
	}
	

	public Departamento atualizar(Long id, Departamento departamento) {
		departamento.setId(id);
		return repository.save(departamento);
		
	}
	
	private void validarId(Long id) {

		repository.findById(id).orElseThrow(() -> new NotFoundIdException("ID "+id+" não encontrado!"));

	}
	
}
