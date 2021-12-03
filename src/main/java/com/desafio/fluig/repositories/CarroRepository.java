package com.desafio.fluig.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.fluig.dto.CarroConsumoDTO;
import com.desafio.fluig.model.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Long> {
	
	@Query("SELECT new com.desafio.fluig.dto.CarroConsumoDTO(carro.nome as nome, carro.marca as marca, carro.modelo as modelo, carro.dataFabricacao as dataFabricacao, carro.consumoMedioKmLitroCidade as consumoMedioKmLitroCidade, carro.consumoMedioKmLitroRodovia as consumoMedioKmLitroRodovia, (:totalKmRodadoCidade / carro.consumoMedioKmLitroCidade + :totalKmRodadoRodovia / carro.consumoMedioKmLitroRodovia) as consumoTotal) FROM Carro carro ORDER BY consumoTotal asc")
	List<CarroConsumoDTO> consultarRankingMenorConsumoCombustivel(BigDecimal totalKmRodadoCidade,
			BigDecimal totalKmRodadoRodovia);
	

}
