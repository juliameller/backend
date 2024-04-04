// Crie um web service capaz de prover através de requisição GET uma mensagem
// como a do exercício 01 / exercício 02. Novas mensagens/jogadores devem ser
// geradas à cada requisição. O web service deverá carregar uma lista de nomes,
// sobrenomes, posições e clubes apenas durante sua inicialização.
package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(Application.class, args);
        GeradorJogador.atualizaListas();
    }
}

