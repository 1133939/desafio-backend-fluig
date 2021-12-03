# desafio-backend-fluig

Deve configurar o path do Java 11 na IDE a qual for executar</br>
Deve possuir maven instalado</br>
Executar 'mvn clean install'

ENDPOINT POST: Salvar carro</br>
http://localhost:8080/carro</br>
{</br>
"nome" : "NOME 1",</br>
"marca" : "MARCA 1",</br>
"modelo" : "MODELO 1",</br>
"dataFabricacao" : "25/12/1999",</br>
"consumoMedioKmLitroCidade" : "77.50",</br>
"consumoMedioKmLitroRodovia" : "1.52"</br>
}</br>

----------------------------------------------------------------------------------------------------------

ENDPOINT GET: Ranking por menor consumo de combustível</br>
http://localhost:8080/carro/ranking-comparativo-combustivel?precoGasolina=5&totalKmRodadoCidade=22&totalKmRodadoRodovias=23.33
