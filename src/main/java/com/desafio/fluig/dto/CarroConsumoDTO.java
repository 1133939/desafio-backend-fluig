package com.desafio.fluig.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.desafio.fluig.interfaces.VeiculoConsumo;

public class CarroConsumoDTO implements VeiculoConsumo {
	
	private String nome;
	private String marca;
	private String modelo;
	private LocalDate dataFabricacao;
	private BigDecimal consumoMedioKmLitroCidade;
	private BigDecimal consumoMedioKmLitroRodovia;
	private BigDecimal consumoTotalCombustivelLitros;

	public CarroConsumoDTO(String nome, String marca, String modelo, LocalDate dataFabricacao,
			BigDecimal consumoMedioKmLitroCidade, BigDecimal consumoMedioKmLitroRodovia, BigDecimal consumoTotalCombustivelLitros) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.consumoMedioKmLitroCidade = consumoMedioKmLitroCidade;
		this.consumoMedioKmLitroRodovia = consumoMedioKmLitroRodovia;
		this.consumoTotalCombustivelLitros = consumoTotalCombustivelLitros;
	}

	public CarroConsumoDTO() {
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}
	
	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	public BigDecimal getConsumoMedioKmLitroCidade() {
		return consumoMedioKmLitroCidade;
	}
	
	public void setConsumoMedioKmLitroCidade(BigDecimal consumoMedioKmLitroCidade) {
		this.consumoMedioKmLitroCidade = consumoMedioKmLitroCidade;
	}
	
	public BigDecimal getConsumoMedioKmLitroRodovia() {
		return consumoMedioKmLitroRodovia;
	}
	
	public void setConsumoMedioKmLitroRodovia(BigDecimal consumoMedioKmLitroRodovia) {
		this.consumoMedioKmLitroRodovia = consumoMedioKmLitroRodovia;
	}	
	
	public void setConsumoCombustivelLitros(BigDecimal consumoTotalCombustivelLitros) {
		this.consumoTotalCombustivelLitros = consumoTotalCombustivelLitros;
	}

	@Override
	public BigDecimal getConsumoCombustivelLitros() {
		return this.consumoTotalCombustivelLitros;
	}
	
}
