package com.alugueldeveiculosserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alugueldeveiculosserver.model.Veiculo;
import com.alugueldeveiculosserver.repository.VeiculoRepository;
import com.alugueldeveiculosserver.utils.Validador;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public ResponseEntity<Veiculo> salvarVeiculo(Veiculo veiculo) {
		Veiculo verificador = this.veiculoRepository.findByPlaca(veiculo.getPlaca());
		
		if(verificador != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Placa Duplicada");
		}
		
		if(Validador.ehVazia(veiculo.getModelo())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo em branco!");
		}
		
		if(Validador.ehVazia(veiculo.getMarca())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca em branco!");
		}
		
		if(Validador.ehVazia(veiculo.getPlaca())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Placa em branco!");
		}
		
		if(veiculo.getSegmento() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Segmento em branco!");
		}
		
		return ResponseEntity.ok(this.veiculoRepository.save(veiculo));
	}

	public ResponseEntity<List<Veiculo>> buscarTodosVeiculos() {
		return ResponseEntity.ok(this.veiculoRepository.findAll());
	}

	public ResponseEntity<Veiculo> buscarPorId(Integer id) {
		return ResponseEntity.ok(this.veiculoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não localizado!")));
	}

	public ResponseEntity<Void> removerPorId(Integer id) {
		this.veiculoRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}

	
	

}
