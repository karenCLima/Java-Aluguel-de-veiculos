package com.alugueldeveiculosserver.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugueldeveiculosserver.model.Cliente;
import com.alugueldeveiculosserver.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
		return this.clienteService.salvarCliente(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarClientes(){
		return this.clienteService.buscarClientes();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id){
		return this.clienteService.buscarPorId(id);
	}
	
	@GetMapping("excluir/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Integer id){
		return this.clienteService.excluirPorId(id);
	}
	
	

}
