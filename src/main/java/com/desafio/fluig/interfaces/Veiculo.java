package com.desafio.fluig.interfaces;

import java.time.LocalDate;

public interface Veiculo extends ConsumoMedioKmLitro{
String getNome();
String getMarca();
String getModelo();
LocalDate getDataFabricacao();
}
