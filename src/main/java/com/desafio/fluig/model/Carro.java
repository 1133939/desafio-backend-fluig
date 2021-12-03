package com.desafio.fluig.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.fluig.interfaces.Veiculo;

@Entity
@Table(name = "TB_CARRO")
public class Carro implements Veiculo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARRO")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "MARCA", nullable = false)
	private String marca;
	@Column(name = "MODELO", nullable = false)
	private String modelo;
	@Column(name = "DT_FABRICACAO", nullable = false)
	private LocalDate dataFabricacao;
	
	@Column(name = "CONSUMO_CIDADE_KML", nullable = false, columnDefinition = "DECIMAL", precision = 2)
	private BigDecimal consumoMedioKmLitroCidade;
	@Column(name = "CONSUMO_RODOVIA_KML", nullable = false, columnDefinition = "DECIMAL", precision = 2)
	private BigDecimal consumoMedioKmLitroRodovia;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public BigDecimal getConsumoMedioKmLitroCidade() {
		return consumoMedioKmLitroCidade;
	}

	public BigDecimal getConsumoMedioKmLitroRodovia() {
		return consumoMedioKmLitroRodovia;
	}
	
	public void setConsumoMedioKmLitroCidade(BigDecimal consumoMedioKmLitroCidade) {
		this.consumoMedioKmLitroCidade = consumoMedioKmLitroCidade;
	}

	public void setConsumoMedioKmLitroRodovia(BigDecimal consumoMedioKmLitroRodovia) {
		this.consumoMedioKmLitroRodovia = consumoMedioKmLitroRodovia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	
	
	
}
