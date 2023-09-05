package com.alugueldeveiculosserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alugueldeveiculosserver.model.Cliente;
import com.alugueldeveiculosserver.repository.ClienteRepository;
import com.alugueldeveiculosserver.utils.Validador;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ResponseEntity<Cliente> salvarCliente(Cliente cliente) {
		if(!Validador.validaCpf(cliente.getCpf())) {
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); Nessa não aparece uma mensagem!
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF inválido!");
		}
		Cliente verificador =this.clienteRepository.findByCpf(cliente.getCpf());
		if(verificador!= null && !verificador.getId().equals(cliente.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF duplicado!");
		}
		this.clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	

	public ResponseEntity<List<Cliente>> buscarClientes() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	public ResponseEntity<Cliente> buscarPorId(Integer id) {
		Cliente cliente = this.clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado!"));	
		return ResponseEntity.ok(cliente);
	}

	public ResponseEntity<Void> excluirPorId(Integer id) {
		this.clienteRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
