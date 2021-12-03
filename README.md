# desafio-backend-fluig

ENDPOINT POST: Salvar carro

http://localhost:8080/carro

{
"nome" : "NOME 1",
"marca" : "MARCA 1",
"modelo" : "MODELO 1",
"dataFabricacao" : "25/12/1999",
"consumoMedioKmLitroCidade" : "77.50",
"consumoMedioKmLitroRodovia" : "1.52"
}

----------------------------------------------------------------------------------------------------------

ENDPOINT GET: Ranking por menor consumo de combustível

http://localhost:8080/carro/ranking-comparativo-combustivel?precoGasolina=5&totalKmRodadoCidade=22&totalKmRodadoRodovias=23.33
