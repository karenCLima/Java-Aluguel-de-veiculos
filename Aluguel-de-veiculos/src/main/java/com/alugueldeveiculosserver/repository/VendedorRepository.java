package com.alugueldeveiculosserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alugueldeveiculosserver.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

	public Vendedor findByCpf(String cpf);

}
