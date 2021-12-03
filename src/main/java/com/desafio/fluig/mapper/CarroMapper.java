package com.desafio.fluig.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desafio.fluig.dto.CarroFormDTO;
import com.desafio.fluig.model.Carro;

@Mapper
public interface CarroMapper {
	
	CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);
	
	Carro converterCarroFormParaEntidade(CarroFormDTO dto);
}
