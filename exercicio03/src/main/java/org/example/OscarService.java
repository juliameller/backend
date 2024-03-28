package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OscarService {
    ArrayList<Indicacao> indicacoes = new ArrayList<>();

    @Autowired
    Indicavel indicavel;

    public void adicionarIndicacao(Indicacao indicacao) {
        Indicavel indicavel = indicacao.getIndicavel();
        if (indicavel.isElegivel()) {
            indicavel.incrementarNumeroDeIndicacoes();
            indicacoes.add(indicacao);
        } else {
            System.out.println("Este elemento não é elegível para indicação.");
        }
    }
    public void mostraListaIndicados() {
        System.out.println("Lista de indicados:");
        for (Indicacao indicacao : indicacoes) {
            Indicavel indicavel = indicacao.getIndicavel();
            System.out.println("- Categoria: " + indicacao.getCategoria() + ", Nome: " + indicavel.toString());
        }
    }
}


