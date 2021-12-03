package com.desafio.fluig.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.desafio.fluig.interfaces.DadosPrevisaoGastos;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosPrevisaoGastosDTO implements DadosPrevisaoGastos {
	
	@JsonProperty("precoGasolina")
	@NotNull(message = "precoGasolina não pode ser nulo.")
	private BigDecimal precoGasolina;
	
	@JsonProperty("totalKmRodadoCidade")
	@NotNull(message = "totalKmRodadoCidade não pode ser nulo.")
	private BigDecimal totalKmRodadoCidade;
	
	@JsonProperty("totalKmRodadoRodovias")
	@NotNull(message = "totalKmRodadoRodovias não pode ser nulo.")
	private BigDecimal totalKmRodadoRodovias;
	
	public BigDecimal getPrecoCombustivel() {
		return precoGasolina;
	}
	
	public BigDecimal getTotalKmRodadoCidade() {
		return totalKmRodadoCidade != null ? totalKmRodadoCidade : BigDecimal.ZERO;
	}
	
	public BigDecimal getTotalKmRodadoRodovias() {
		return totalKmRodadoRodovias != null ? totalKmRodadoRodovias : BigDecimal.ZERO;
	}
	
	public void setPrecoGasolina(BigDecimal precoGasolina) {
		this.precoGasolina = precoGasolina;
	}
	
	public void setTotalKmRodadoCidade(BigDecimal totalKmRodadoCidade) {
		this.totalKmRodadoCidade = totalKmRodadoCidade;
	}
	
	public void setTotalKmRodadoRodovias(BigDecimal totalKmRodadoRodovias) {
		this.totalKmRodadoRodovias = totalKmRodadoRodovias;
	}
	
	
}
