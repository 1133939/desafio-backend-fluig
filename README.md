# desafio-backend-fluig

Deve configurar o path do Java 11 na IDE a qual for executar
Deve possuir maven instalado
Executar 'mvn clean install'

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
