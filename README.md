# Conversor de Moedas (Java)

Projeto simples de linha de comando que converte valores entre moedas usando a ExchangeRate-API. O usuario informa a moeda de origem, a moeda de destino e o valor; o programa consulta a taxa e calcula o valor convertido.

## Como funciona
1. O usuario informa `moedaOriginal`, `moedaDesejada` e o `valorOriginal`.
2. O programa chama `https://v6.exchangerate-api.com/v6/<API_KEY>/pair/<BASE>/<TARGET>`.
3. A resposta JSON e convertida para `ReferenciaEnchangeApi`.
4. O `Conversor` calcula `valorConvertido` usando `conversion_rate`.

## Funcionalidades
- Leitura interativa via terminal.
- Consulta de taxa de cambio no endpoint `pair` da ExchangeRate-API.
- Conversao usando `record` do Java para manter o modelo de dados simples.

## Como iniciar o projeto
### Modo geral
1. Tenha o JDK 17 instalado.
2. Tenha uma API key da ExchangeRate-API.
3. Atualize a API key no endpoint em `src/Main.java`.
4. Rode pelo IntelliJ ou via terminal.

### Via IntelliJ
1. Abra o projeto no IntelliJ.
2. Configure o JDK 17 no projeto.
3. Rode a classe `Main`.

### Via terminal (javac/java)
Se o jar do Gson estiver em `lib/gson-2.10.1.jar`:

```bash
javac -cp ".;lib/gson-2.10.1.jar" src\*.java
java -cp ".;lib/gson-2.10.1.jar;src" Main
```

No Windows, use `;` como separador de classpath. Em Linux/Mac, use `:`.

## Estrutura do projeto
- `src/Main.java`: fluxo principal, leitura de entrada e chamada da API.
- `src/Conversor.java`: record que calcula a conversao.
- `src/ReferenciaEnchangeApi.java`: record para mapear o JSON da API.
- `out/`: classes compiladas (geradas pela IDE).

## Possiveis melhorias
- Validar moedas e valores (ex: impedir entradas vazias).
- Tratar erros de API (status, mensagens, limites de uso).
- Separar a API key em variavel de ambiente.
- Exibir mais dados da resposta (ex: taxa, data, base).

## Licenca
Projeto educacional / uso livre.
