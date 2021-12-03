package com.desafio.fluig.interfaces;

import java.math.BigDecimal;

public interface DadosPrevisaoGastos extends PrecoCombustivel {
	BigDecimal getTotalKmRodadoCidade();
	BigDecimal getTotalKmRodadoRodovias();
}
