package com.desafio.fluig.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.fluig.dto.CarroConsumoDTO;
import com.desafio.fluig.dto.DadosPrevisaoGastosDTO;
import com.desafio.fluig.dto.VeiculoConsumoDTO;
import com.desafio.fluig.exception.FluigException;
import com.desafio.fluig.interfaces.DadosPrevisaoGastos;
import com.desafio.fluig.interfaces.VeiculoConsumo;

@ExtendWith(SpringExtension.class)
public class VeiculoConsumoServiceTest {
	
	@InjectMocks
	private VeiculoConsumoService service;
	
	@Test
	public void deve_lancar_exception_sem_preco_combustivel() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTOSemPrecoCombustivel();
		
		FluigException exception = Assertions.assertThrows(FluigException.class, () -> service.converterParaVeiculoConsumoDTO(veiculo, dados));
		
		assertEquals("precoCombustivel não deve ser nulo", exception.getMessage());
	}
	
	@Test
	public void deve_lancar_exception_sem_consumo_combustivel_em_litros() {
		VeiculoConsumo veiculo = obterCarroConsumoSemConsumoCombustivel();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		FluigException exception = Assertions.assertThrows(FluigException.class, () -> service.converterParaVeiculoConsumoDTO(veiculo, dados));
		
		assertEquals("consumoCombustivelLitros não deve ser nulo", exception.getMessage());
	}
	
	@Test
	public void deve_setar_valor_para_quantidade_combustivel_gasto_em_litros() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertThat(retorno.getConsumoCombustivelLitros()).isEqualTo(new BigDecimal("50.00"));
	}
	
	@Test
	public void deve_setar_valor_total_gasto_em_combustivel() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertThat(retorno.getValorGastoCombustivel()).isEqualTo(new BigDecimal("125.00"));
	}
	
	@Test
	public void deve_converter_data_fabricacao_para_ano_fabricacao() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertEquals(2000, retorno.getAnoFabricacao());
	}
	
	@Test
	public void deve_conter_nome_do_veiculo() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertEquals("NOME_CARRO", retorno.getNome());
	}
	
	@Test
	public void deve_conter_modelo_do_veiculo() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertEquals("MODELO_CARRO", retorno.getModelo());
	}
	
	@Test
	public void deve_conter_marca_veiculo() {
		VeiculoConsumo veiculo = obterCarroConsumo();
		DadosPrevisaoGastos dados = obterDadosPrevisaoGastosDTO();
		
		VeiculoConsumoDTO retorno = service.converterParaVeiculoConsumoDTO(veiculo, dados);
		
		assertEquals("MARCA_CARRO", retorno.getMarca());
	}
	
	private VeiculoConsumo obterCarroConsumo() {
		CarroConsumoDTO carro = new CarroConsumoDTO();
		carro.setNome("NOME_CARRO");
		carro.setMarca("MARCA_CARRO");
		carro.setModelo("MODELO_CARRO");
		carro.setDataFabricacao(LocalDate.of(2000, 12, 25));
		carro.setConsumoMedioKmLitroCidade(new BigDecimal("22.55"));
		carro.setConsumoMedioKmLitroRodovia(new BigDecimal("25.55"));
		carro.setConsumoCombustivelLitros(new BigDecimal("50"));
		return carro;
	}
	
	private VeiculoConsumo obterCarroConsumoSemConsumoCombustivel() {
		CarroConsumoDTO carro = new CarroConsumoDTO();
		carro.setNome("NOME_CARRO");
		carro.setMarca("MARCA_CARRO");
		carro.setModelo("MODELO_CARRO");
		carro.setDataFabricacao(LocalDate.of(2000, 12, 25));
		carro.setConsumoMedioKmLitroCidade(new BigDecimal("22.55"));
		carro.setConsumoMedioKmLitroRodovia(new BigDecimal("25.55"));
		carro.setConsumoCombustivelLitros(null);
		return carro;
	}

	private DadosPrevisaoGastos obterDadosPrevisaoGastosDTO() {
		DadosPrevisaoGastosDTO dados = new DadosPrevisaoGastosDTO();
		dados.setTotalKmRodadoCidade(new BigDecimal("22.42"));
		dados.setTotalKmRodadoRodovias(new BigDecimal("22.2"));
		dados.setPrecoGasolina(new BigDecimal("2.50"));
		return dados;
	}
	
	private DadosPrevisaoGastos obterDadosPrevisaoGastosDTOSemPrecoCombustivel() {
		DadosPrevisaoGastosDTO dados = new DadosPrevisaoGastosDTO();
		dados.setTotalKmRodadoCidade(new BigDecimal("22.42"));
		dados.setTotalKmRodadoRodovias(new BigDecimal("22.2"));
		dados.setPrecoGasolina(null);
		return dados;
	}

}
