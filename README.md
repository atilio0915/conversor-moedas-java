# Conversor de Moedas (Java)

Projeto simples de linha de comando que converte valores entre moedas usando a ExchangeRate-API. O usuario informa a moeda de origem, a moeda de destino e o valor; o programa consulta a taxa e calcula o valor convertido.

## Como iniciar o projeto
1. Tenha o JDK 17 instalado.
2. Tenha uma API key da ExchangeRate-API.
3. Atualize a API key no endpoint em `src/Main.java`.
4. Rode pelo IntelliJ ou via terminal.

### Depedencias 
As dependências são basicamente:

1. JDK 17
2. Gson 2.10.1
3. Uma API key da ExchangeRate-API

### Via terminal
1. Abra o projeto no IntelliJ.
2. Configure o JDK 17 no projeto.
3. Rode a classe `Main`.
4. javac -cp "lib\gson-2.10.1.jar;." src\*.java
5. java -cp "lib\gson-2.10.1.jar;src;." Main

