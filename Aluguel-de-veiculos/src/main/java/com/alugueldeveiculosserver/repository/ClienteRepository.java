package com.alugueldeveiculosserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alugueldeveiculosserver.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public Cliente findByCpf(String cpf);
}
