package com.api.cadastro.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.funcionario.entity.Cargo;
import com.api.cadastro.funcionario.exception.NotFoundIdException;
import com.api.cadastro.funcionario.repository.CargoRepository;


@Service
public class CargoService {

	@Autowired
	CargoRepository repository;
	
	public List<Cargo> listar() {
		List<Cargo> cargos = repository.findAll();
		return cargos;
	}
	
	public Cargo cadastrar(Cargo cargo) {
		
		return repository.save(cargo);
		
	}

	public Cargo buscarPorId(Long id)  {
		this.validarId(id);
		
		return repository.findById(id).get();
		
	}
	
	public void deletar(Long id) {
		this.validarId(id);
		repository.deleteById(id);
	}
	
	public Cargo atualizar(Long id, Cargo cargo) {
		cargo.setId(id);
		return repository.save(cargo);
		
	}
	private void validarId(Long id) {

		repository.findById(id).orElseThrow(() -> new NotFoundIdException("ID "+id+" não encontrado!"));

	}

	
	
}
