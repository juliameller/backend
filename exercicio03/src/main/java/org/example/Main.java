package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        OscarService oscarService = context.getBean(OscarService.class);

        // Filmes
        Filme filme1 = context.getBean(Filme.class, "Oppenheimer", "Obra de Época");
        Filme filme2 = context.getBean(Filme.class, "Barbie", "Comédia/Fantasia");
        Filme filme3 = context.getBean(Filme.class, "Pobres Criaturas", "Comédia");
        Filme filme4 = context.getBean(Filme.class, "Anatomia de uma Queda", "Drama");

        // Atores
        Ator ator1 = context.getBean(Ator.class, "Cillian Murphy", "Irlanda");
        Ator ator2 = context.getBean(Ator.class, "Bradley Cooper", "EUA");
        Ator ator3 = context.getBean(Ator.class, "Colman Domingo", "EUA");
        Ator ator4 = context.getBean(Ator.class, "Paul Giamatti", "EUA");

        // Indicações
        Indicacao indicacaoFilme1 = context.getBean(Indicacao.class,filme1, "Melhor Filme");
        Indicacao indicacaoFilme2 = context.getBean(Indicacao.class,filme2, "Melhor Filme");
        Indicacao indicacaoFilme3 = context.getBean(Indicacao.class,filme3, "Melhor Filme");
        Indicacao indicacaoFilme4 = context.getBean(Indicacao.class,filme4, "Melhor Filme");
        Indicacao indicacaoAtor1 = context.getBean(Indicacao.class,ator1, "Melhor Ator");
        Indicacao indicacaoAtor2 = context.getBean(Indicacao.class,ator2, "Melhor Ator");
        Indicacao indicacaoAtor3 = context.getBean(Indicacao.class,ator3, "Melhor Ator");
        Indicacao indicacaoAtor4 = context.getBean(Indicacao.class,ator4, "Melhor Ator");

        oscarService.adicionarIndicacao(indicacaoFilme1);
        oscarService.adicionarIndicacao(indicacaoFilme2);
        oscarService.adicionarIndicacao(indicacaoFilme3);
        oscarService.adicionarIndicacao(indicacaoFilme4);
        oscarService.adicionarIndicacao(indicacaoAtor1);
        oscarService.adicionarIndicacao(indicacaoAtor2);
        oscarService.adicionarIndicacao(indicacaoAtor3);
        oscarService.adicionarIndicacao(indicacaoAtor4);

//        // Exibe a lista de indicados
        oscarService.mostraListaIndicados();
    }
}