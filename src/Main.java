import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a moeda original (ex: USD): ");
        String moedaOrginal = scanner.nextLine();

        System.out.print("Digite a moeda desejada (ex: BRl): ");
        String moedaDesejada = scanner.nextLine();

        System.out.print("Digite o valor em " + moedaOrginal + ":");
        float valorOriginal = scanner.nextFloat();

        String endereço = "https://v6.exchangerate-api.com/v6/19c63006ba7873c2595c0be0/pair/"+moedaOrginal+"/"+ moedaDesejada;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereço))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            //O response.body retorna uma striing de json ex "{\"nome\":\"Maria\",\"idade\":30}"

            // cria objeto json
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            //converte a resposta JSON (String) para Objeto JsonObjeto
            ReferenciaEnchangeApi referenciaEnchangeApi = gson.fromJson(response.body(), ReferenciaEnchangeApi.class);

            // passa como parametro os atributos se referencia
            Conversor conversor = new Conversor(referenciaEnchangeApi, valorOriginal);
            System.out.println("o valor em " + conversor.moedaDesejada() + " = " + conversor.valorConvertido());

            // converte para string json novamente so q bonito
            String jsonFormatado = gson.toJson(referenciaEnchangeApi);


        }catch (IOException e) {
            System.err.println("Erro: verificar conexao com a api");
        }catch (InterruptedException e) {
            System.err.println("Erro : requisicao interrompida");
        }


    }
}