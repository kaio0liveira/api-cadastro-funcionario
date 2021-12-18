package com.api.cadastro.funcionario.dto;

import com.api.cadastro.funcionario.entity.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {
	
	private Long id;
	private String nome;
	
	
	public  DepartamentoDTO toDepartamentoDTO(Departamento departamento) {
		id = departamento.getId();
		nome = departamento.getNome();
		return this;
	}

}
