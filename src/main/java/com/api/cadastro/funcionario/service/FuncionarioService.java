package com.api.cadastro.funcionario.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.funcionario.entity.Funcionario;
import com.api.cadastro.funcionario.exception.NotFoundIdException;
import com.api.cadastro.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository repository;
	
	
	public List<Funcionario> listar() {
		return repository.findAll();
	}
	
	public Funcionario buscarPorId(Long id)  {
		this.validarId(id);
		return repository.findById(id).get();
	}
	
	public Funcionario cadastrar(Funcionario funcionario) {
		
		return repository.save(funcionario);
		
	}

	public void  deletar(Long id) {
		
		repository.deleteById(id);
	}

	public Funcionario atualizar(Long id, Funcionario funcionario) {
		
		funcionario.setId(id);
		return repository.save(funcionario);
		
	}
	private void validarId(Long id) {
		
		 repository.findById(id).orElseThrow(() -> new NotFoundIdException("ID "+id+" não encontrado!"));
	}

}
