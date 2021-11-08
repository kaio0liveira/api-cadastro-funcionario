package com.api.cadastro.funcionario.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cadastro.funcionario.entity.Funcionario;
import com.api.cadastro.funcionario.exception.NotFoundException;
import com.api.cadastro.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository repository;
	
	
	public List<Funcionario> listar() {
		return repository.findAll();
	}
	
	public Funcionario buscarPorId(Long id) throws NotFoundException {

		return repository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado!"));
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

}
