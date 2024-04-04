package org.example;
import org.springframework.stereotype.Component;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;

@Component
public class GeradorJogador {
    private static final String uri = "https://venson.net.br/resources/data";
    private static final String uriNomes      = uri + "/nomes.txt";
    private static final String uriSobrenomes = uri + "/sobrenomes.txt";
    private static final String uriPosicoes   = uri + "/posicoes.txt";
    private static final String uriClubes     = uri + "/clubes.txt";

    private static String[] listaDeNomes;
    private static String[] listaDeSobrenomes;
    private static String[] listaDePosicoes;
    private static String[] listaDeClubes;



    private static String[] chamaLista(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String texto = response.body();
        return texto.split("\n");
    }

    public static void atualizaListas() throws IOException, InterruptedException {
        listaDeNomes = chamaLista(uriNomes);
        listaDeSobrenomes = chamaLista(uriSobrenomes);
        listaDePosicoes = chamaLista(uriPosicoes);
        listaDeClubes = chamaLista(uriClubes);
    }

    private static int geraNumeroAleatorio(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    private static String escolheItemDaLista(String[] lista) {
        int randomIndex = (int) Math.floor(Math.random() * lista.length);
        return lista[randomIndex];
    }

    public static Jogador geraJogador() {
        String nome = escolheItemDaLista(listaDeNomes);
        String sobrenome = escolheItemDaLista(listaDeSobrenomes);
        String posicao = escolheItemDaLista(listaDePosicoes);
        String clube = escolheItemDaLista(listaDeClubes);
        return new Jogador(nome, sobrenome, posicao, clube, geraNumeroAleatorio(17, 40));
    }
}