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

import com.alugueldeveiculosserver.model.Veiculo;
import com.alugueldeveiculosserver.service.VeiculoService;



@RestController
@RequestMapping("/veiculo")
public class VeiculoRest {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Veiculo> salvarVeiculo(@RequestBody Veiculo veiculo) {
		return this.veiculoService.salvarVeiculo(veiculo);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> buscarTodosVeiculos(){
		return this.veiculoService.buscarTodosVeiculos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable Integer id){
		return this.veiculoService.buscarPorId(id);
	}
	
	@GetMapping("/excluir/{id}")
	public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
		return this.veiculoService.removerPorId(id);
	}
}
