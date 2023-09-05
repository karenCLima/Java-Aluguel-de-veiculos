package com.alugueldeveiculosserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Veiculo {
	
	public enum Cor{
		PRETO, BRANCO, CINZA, VERMELHO, AZUL, ROSA, BORDO
	}
	
	public enum Combustivel{
		GASOLINA, DIESEL, ALCOOL, HIBRIDO
	}
	
	public enum Status{
		LIVRE, ALUGADO
	}
	
	public enum Segmento{
		CARRO, MOTO, CAMINHAO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String marca;
	
	private String modelo;
	
	@Column (unique = true)
	private String placa;
	
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private Combustivel combustivel;
	
	@Enumerated(EnumType.STRING)
	private Segmento segmento;
	

}
