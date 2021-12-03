package com.desafio.fluig.dto;

import java.math.BigDecimal;

public class VeiculoConsumoDTO {
	
	private String nome;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private BigDecimal consumoCombustivelLitros;
	private BigDecimal valorGastoCombustivel;
	
	public String getNome() {
		return nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public BigDecimal getConsumoCombustivelLitros() {
		return consumoCombustivelLitros;
	}
	
	public BigDecimal getValorGastoCombustivel() {
		return valorGastoCombustivel;
	}
	
	public void setConsumoCombustivelLitros(BigDecimal quantidadeCombustivelGasto) {
		this.consumoCombustivelLitros = quantidadeCombustivelGasto;
	}
	
	public void setValorGastoCombustivel(BigDecimal valorTotalGasto) {
		this.valorGastoCombustivel = valorTotalGasto;
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

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	
	
	
	
}
