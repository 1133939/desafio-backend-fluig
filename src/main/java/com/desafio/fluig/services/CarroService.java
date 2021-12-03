package com.desafio.fluig.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.fluig.dto.CarroConsumoDTO;
import com.desafio.fluig.dto.CarroFormDTO;
import com.desafio.fluig.dto.DadosPrevisaoGastosDTO;
import com.desafio.fluig.dto.VeiculoConsumoDTO;
import com.desafio.fluig.mapper.CarroMapper;
import com.desafio.fluig.model.Carro;
import com.desafio.fluig.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private VeiculoConsumoService veiculoConsumoService;

	@Transactional
	public Carro salvarCarro(CarroFormDTO carroForm) {
		Carro carro = CarroMapper.INSTANCE.converterCarroFormParaEntidade(carroForm);
		carroRepository.save(carro);
		return carro;
	}
	
	public List<VeiculoConsumoDTO> consultarRankingMenorConsumoCombustivel(DadosPrevisaoGastosDTO dados) {
		List<CarroConsumoDTO> listaRanqueada = carroRepository.consultarRankingMenorConsumoCombustivel(dados.getTotalKmRodadoCidade(), dados.getTotalKmRodadoRodovias());
		return listaRanqueada
				.stream()
				.map(carroConsumo -> veiculoConsumoService.converterParaVeiculoConsumoDTO(carroConsumo, dados))
				.collect(Collectors.toList());
	}

}
