package com.desafio.fluig.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;	
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.fluig.dto.CarroConsumoDTO;
import com.desafio.fluig.dto.CarroFormDTO;
import com.desafio.fluig.dto.DadosPrevisaoGastosDTO;
import com.desafio.fluig.dto.VeiculoConsumoDTO;
import com.desafio.fluig.model.Carro;
import com.desafio.fluig.repositories.CarroRepository;

@ExtendWith(SpringExtension.class)
public class CarroServiceTest {

	@InjectMocks
	private CarroService service;
	
	@Mock
	private VeiculoConsumoService veiculoConsumoService;
	
	@Mock
	private CarroRepository carroRepository;
	
	@Test
	public void deve_salvar_carro() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		service.salvarCarro(form);
		
		verify(carroRepository, times(1)).save(any(Carro.class));
	}
	
	@Test
	public void deve_converter_atributo_nome_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertEquals("NOME_CARRO", carro.getNome());
	}
	
	@Test
	public void deve_converter_atributo_marca_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertEquals("MARCA_CARRO", carro.getMarca());
	}
	
	@Test
	public void deve_converter_atributo_modelo_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertEquals("MODELO_CARRO", carro.getModelo());
	}
	
	@Test
	public void deve_converter_atributo_data_fabricacao_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertEquals(LocalDate.MIN, carro.getDataFabricacao());
	}
	
	
	@Test
	public void deve_converter_atributo_consumo_cidade_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertThat(carro.getConsumoMedioKmLitroCidade()).isEqualTo(new BigDecimal("20"));
	}
	
	@Test
	public void deve_converter_atributo_consumo_rodovia_para_entidade() {
		CarroFormDTO form = obterCarroFormPreenchido();
		
		Carro carro = service.salvarCarro(form);
		
		assertThat(carro.getConsumoMedioKmLitroRodovia()).isEqualTo(new BigDecimal("22.55"));
	}
	
	@Test
	public void deve_retornar_lista_vazia_quando_consulta_nao_encontrar_resultados() {
		DadosPrevisaoGastosDTO dados = obterDadosPrevisaoGastosDTO();
		when(carroRepository.consultarRankingMenorConsumoCombustivel(dados.getTotalKmRodadoCidade(), dados.getTotalKmRodadoRodovias()))
			.thenReturn(Collections.emptyList());
		
		List<VeiculoConsumoDTO> retorno = service.consultarRankingMenorConsumoCombustivel(dados);
		
		assertEquals(0, retorno.size());
	}
	
	@Test
	public void deve_retornar_lista_convertida_em_veiculo_consumo_dto_quando_consulta_encontrar_resultados() {
		DadosPrevisaoGastosDTO dadosPrevisaoGastos = obterDadosPrevisaoGastosDTO();
		List<CarroConsumoDTO> listaVeiculosRanqueados = Arrays.asList(Mockito.mock(CarroConsumoDTO.class), Mockito.mock(CarroConsumoDTO.class));
		when(carroRepository.consultarRankingMenorConsumoCombustivel(dadosPrevisaoGastos.getTotalKmRodadoCidade(), dadosPrevisaoGastos.getTotalKmRodadoRodovias())).thenReturn(listaVeiculosRanqueados);
		when(veiculoConsumoService.converterParaVeiculoConsumoDTO(listaVeiculosRanqueados.get(0), dadosPrevisaoGastos)).thenReturn(Mockito.mock(VeiculoConsumoDTO.class));
		when(veiculoConsumoService.converterParaVeiculoConsumoDTO(listaVeiculosRanqueados.get(1), dadosPrevisaoGastos)).thenReturn(Mockito.mock(VeiculoConsumoDTO.class));
		
		List<VeiculoConsumoDTO> retorno = service.consultarRankingMenorConsumoCombustivel(dadosPrevisaoGastos);
		
		verify(veiculoConsumoService, times(1)).converterParaVeiculoConsumoDTO(listaVeiculosRanqueados.get(0), dadosPrevisaoGastos);
		verify(veiculoConsumoService, times(1)).converterParaVeiculoConsumoDTO(listaVeiculosRanqueados.get(1), dadosPrevisaoGastos);
		assertEquals(2, retorno.size());
	}

	private CarroFormDTO obterCarroFormPreenchido() {
		CarroFormDTO carroFormDTO = new CarroFormDTO();
		carroFormDTO.setConsumoMedioKmLitroCidade(new BigDecimal("20"));
		carroFormDTO.setConsumoMedioKmLitroRodovia(new BigDecimal("22.55"));
		carroFormDTO.setDataFabricacao(LocalDate.MIN);
		carroFormDTO.setMarca("MARCA_CARRO");
		carroFormDTO.setModelo("MODELO_CARRO");
		carroFormDTO.setNome("NOME_CARRO");
		return carroFormDTO;
	}
	
	private DadosPrevisaoGastosDTO obterDadosPrevisaoGastosDTO() {
		DadosPrevisaoGastosDTO dados = new DadosPrevisaoGastosDTO();
		dados.setTotalKmRodadoCidade(new BigDecimal("22.42"));
		dados.setTotalKmRodadoRodovias(new BigDecimal("22.2"));
		return dados;
	}



}
