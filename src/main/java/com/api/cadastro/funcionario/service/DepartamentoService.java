package com.api.cadastro.funcionario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.cadastro.funcionario.dto.DepartamentoDTO;
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
		return repository.findAll();
	}
	
	public static List<DepartamentoDTO> listarDTO(List<Departamento> list)  {
		
		return list.stream().map(d -> new DepartamentoDTO().toDepartamentoDTO(d))
		.collect(Collectors.toList());
		
		
	}
	
	public Departamento cadastrar(Departamento departamento) {
		
		return repository.save(departamento);
		
	}

	public Departamento buscarPorId(Long id)  {
		this.validarId(id);
		
		return repository.findById(id).get();
		
	}
	public DepartamentoDTO buscarPorIdDTO(Long id)  {
		this.validarId(id);
		Departamento dep = repository.findById(id).get();
		return new DepartamentoDTO().toDepartamentoDTO(dep);
		
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
