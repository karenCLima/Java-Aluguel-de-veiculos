package com.alugueldeveiculosserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alugueldeveiculosserver.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	
	public Veiculo findByPlaca(String placa);
}
