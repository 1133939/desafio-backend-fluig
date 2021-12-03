package com.desafio.fluig.builder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.desafio.fluig.dto.VeiculoConsumoDTO;

public class VeiculoConsumoBuilder {
	
	private VeiculoConsumoDTO veiculo;
	
	public VeiculoConsumoBuilder() {
		this.veiculo = new VeiculoConsumoDTO();
	}
	
	public VeiculoConsumoBuilder addNome(String nome) {
		this.veiculo.setNome(nome);
		return this;
	}
	
	public VeiculoConsumoBuilder addMarca(String marca) {
		this.veiculo.setMarca(marca);
		return this;
	}
	
	public VeiculoConsumoBuilder addModelo(String modelo) {
		this.veiculo.setModelo(modelo);
		return this;
	}
	
	public VeiculoConsumoBuilder addAnoFabricacao(LocalDate dataFabricacao) {
		this.veiculo.setAnoFabricacao(dataFabricacao != null ? dataFabricacao.getYear() : null);
		return this;
	}
	
	public VeiculoConsumoBuilder addQuantidadeCombustivelGasto(BigDecimal quantidade) {
		if(quantidade != null)
			this.veiculo.setConsumoCombustivelLitros(quantidade.setScale(2, RoundingMode.HALF_UP));
		return this;
	}
	
	public VeiculoConsumoBuilder addValorGastoCombustivel(BigDecimal valorTotalGasto) {
		this.veiculo.setValorGastoCombustivel(valorTotalGasto);
		return this;
	}

	public VeiculoConsumoDTO build() {
		return this.veiculo;
	}

}
