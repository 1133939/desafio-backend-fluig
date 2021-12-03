package com.desafio.fluig.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.desafio.fluig.builder.VeiculoConsumoBuilder;
import com.desafio.fluig.dto.VeiculoConsumoDTO;
import com.desafio.fluig.interfaces.PrecoCombustivel;
import com.desafio.fluig.interfaces.VeiculoConsumo;
import com.desafio.fluig.util.FluigUtils;

@Service
public class VeiculoConsumoService {
	
	public VeiculoConsumoDTO converterParaVeiculoConsumoDTO(VeiculoConsumo veiculo, PrecoCombustivel precoCombustivel) {
		validarCamposNulos(veiculo, precoCombustivel);
		
		BigDecimal valorGastoComCombustivel = precoCombustivel.getPrecoCombustivel().multiply(veiculo.getConsumoCombustivelLitros()).setScale(2, RoundingMode.HALF_UP);
		
		return new VeiculoConsumoBuilder()
				.addNome(veiculo.getNome())
				.addMarca(veiculo.getMarca())
				.addModelo(veiculo.getModelo())
				.addAnoFabricacao(veiculo.getDataFabricacao())
				.addQuantidadeCombustivelGasto(veiculo.getConsumoCombustivelLitros())
				.addValorGastoCombustivel(valorGastoComCombustivel)
				.build();
	}

	private void validarCamposNulos(VeiculoConsumo veiculo, PrecoCombustivel precoCombustivel) {
		FluigUtils.campoNaoDeveSerNulo("precoCombustivel não deve ser nulo", precoCombustivel.getPrecoCombustivel());
		FluigUtils.campoNaoDeveSerNulo("consumoCombustivelLitros não deve ser nulo", veiculo.getConsumoCombustivelLitros());
	}

}
