package com.api.cadastro.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cadastro.funcionario.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	
}
