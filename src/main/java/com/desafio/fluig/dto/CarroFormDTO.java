package com.desafio.fluig.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.desafio.fluig.util.LocalDateFluigDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class CarroFormDTO {
	
	@NotEmpty(message = "Nome é obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Marca é obrigatória")
	private String marca;
	
	@NotEmpty(message = "Modelo é obrigatorio")
	private String modelo;
	
	@PastOrPresent(message = "Data deve estar no passado.")
	@NotNull
	@JsonDeserialize(using = LocalDateFluigDeserializer.class)
	private LocalDate dataFabricacao;
	
	@NotNull(message = "Consumo médio na cidade KM/L é obrigatorio")
	private BigDecimal consumoMedioKmLitroCidade;
	
	@NotNull(message = "Consumo médio na rodovia KM/L  é obrigatorio")
	private BigDecimal consumoMedioKmLitroRodovia;
	
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

	public void setConsumoMedioKmLitroCidade(BigDecimal consumoMedioKmLitroCidade) {
		this.consumoMedioKmLitroCidade = consumoMedioKmLitroCidade;
	}

	public void setConsumoMedioKmLitroRodovia(BigDecimal consumoMedioKmLitroRodovia) {
		this.consumoMedioKmLitroRodovia = consumoMedioKmLitroRodovia;
	}
	
	
	
	
}
