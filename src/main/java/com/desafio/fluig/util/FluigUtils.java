package com.desafio.fluig.util;

import java.util.Objects;

import com.desafio.fluig.exception.FluigException;

public interface FluigUtils {

	public static void campoNaoDeveSerNulo(String mensagem, Object campo){
		if(Objects.isNull(campo))
			throw new FluigException(mensagem);
	}
}
