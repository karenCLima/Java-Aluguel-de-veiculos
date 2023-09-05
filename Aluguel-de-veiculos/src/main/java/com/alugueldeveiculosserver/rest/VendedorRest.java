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

import com.alugueldeveiculosserver.model.Vendedor;
import com.alugueldeveiculosserver.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorRest {
	
	@Autowired
	private VendedorService vendedorService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Vendedor> salvarVendedor(@RequestBody Vendedor vendedor){
		return this.vendedorService.salvarVendedor(vendedor);
	}
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> buscarVendedores(){
		return this.vendedorService.buscarVendedores();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> buscarVendedor(@PathVariable Integer id){
		return this.vendedorService.buscarPorId(id);
	}
	
	@GetMapping("/excluir/{id}")
	public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
		return this.vendedorService.removerPorId(id);
	}

}
