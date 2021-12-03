package com.desafio.fluig.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.fluig.dto.CarroFormDTO;
import com.desafio.fluig.dto.DadosPrevisaoGastosDTO;
import com.desafio.fluig.dto.VeiculoConsumoDTO;
import com.desafio.fluig.services.CarroService;

@RestController
@RequestMapping(value="carro")
public class CarroResource {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping
	public ResponseEntity<Void> salvarCarro(@RequestBody @Valid CarroFormDTO carroForm) {		
		carroService.salvarCarro(carroForm);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(value="ranking-comparativo-combustivel")
	public ResponseEntity<List<VeiculoConsumoDTO>> consultarVeiculosRanqueadosPorValorGastoComCombustivel(@Valid DadosPrevisaoGastosDTO dados) {
		return ResponseEntity.ok().body(carroService.consultarRankingMenorConsumoCombustivel(dados));
	}
	
}
