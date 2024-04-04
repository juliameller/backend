package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {

    @GetMapping("/jogador")
    public String GerarJogador() {
        return GeradorJogador.geraJogador().getFrase();
    }

}
