package com.api.cadastro.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cadastro.funcionario.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
