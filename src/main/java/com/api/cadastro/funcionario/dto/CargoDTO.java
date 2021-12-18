package com.api.cadastro.funcionario.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.api.cadastro.funcionario.entity.Cargo;
import com.api.cadastro.funcionario.entity.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
	
	private String nome;
	private List<Funcionario> funcionarios;
	
	public static List<CargoDTO> toCursoDto(List<Cargo> cargos){
		
		return cargos.stream().map(cargo -> new CargoDTO(cargo.getNome(), cargo.getFuncionarios())).collect(Collectors.toList());
		
	}
}
