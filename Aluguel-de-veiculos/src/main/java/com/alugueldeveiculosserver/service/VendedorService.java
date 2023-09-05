package com.alugueldeveiculosserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alugueldeveiculosserver.model.Vendedor;
import com.alugueldeveiculosserver.repository.VendedorRepository;
import com.alugueldeveiculosserver.utils.Validador;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	public ResponseEntity<Vendedor> salvarVendedor(Vendedor vendedor) {
		if(!Validador.validaCpf(vendedor.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF Inválido!");
		}
		
		Vendedor verificador = this.vendedorRepository.findByCpf(vendedor.getCpf());
		
		if(verificador != null && verificador.getCpf().equals(vendedor.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF Duplicado!");
		}
		
		return ResponseEntity.ok(vendedorRepository.save(vendedor));
	}
	
	public ResponseEntity<List<Vendedor>> buscarVendedores() {
		return ResponseEntity.ok(vendedorRepository.findAll());
	}

	public ResponseEntity<Vendedor> buscarPorId(Integer id) {
		Vendedor vendedor = this.vendedorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não localizado!"));
		return ResponseEntity.ok(vendedor);
	}

	public ResponseEntity<Void> removerPorId(Integer id) {
		this.vendedorRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
