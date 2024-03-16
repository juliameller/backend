// Utilizando como base o exercício anterior, crie uma classe chamada
//JogadorGerador contendo um método capaz de realizar as requisições HTTP
//apenas uma vez e construir múltiplos objetos do tipo Jogador .
//Crie também uma classe chamada Jogador contendo métodos que permitam
//que cada dado do jogador seja acessado individualmente através de métodos
//( getNome , getSobrenome , getPosicao , getIdade , getClube ) e um método que
//gere a mensagem do exercício anterior ( getDescricao ).

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JogadorGerador {
    private static String textoNomes;
    private static String textoSobrenomes;
    private static String textoPosicoes;
    private static String textoClubes;

    public static void realizarRequisicoes() throws Exception {
        textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        textoSobrenomes = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
        textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
    }

    private static String retornaTextoDoServidor(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        return resposta.body();
    }

    public static String getTextoNomes() {
        return textoNomes;
    }

    public static String getTextoSobrenomes() {
        return textoSobrenomes;
    }

    public static String getTextoPosicoes() {
        return textoPosicoes;
    }

    public static String getTextoClubes() {
        return textoClubes;
    }

public static Jogador gerarJogador() {
    String nome = retornaElementoAleatorio(JogadorGerador.getTextoNomes());
    String sobrenome = retornaElementoAleatorio(JogadorGerador.getTextoSobrenomes());
    String posicao = retornaElementoAleatorio(JogadorGerador.getTextoPosicoes());
    String clube = retornaElementoAleatorio(JogadorGerador.getTextoClubes());
    short idade = geraNumeroAleatorio(17, 41);

    return new Jogador(nome, sobrenome, posicao, idade, clube);
}
    private static String retornaElementoAleatorio(String texto) {
        String[] listaDeNomes = texto.replace("\"", "").replace(",", "").split("\n");
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    private static short geraNumeroAleatorio(int menor, int maior) {
        return (short) Math.floor((Math.random() * (maior - menor)) + menor);
    }
}


