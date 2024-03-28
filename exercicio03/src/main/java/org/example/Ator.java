package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ator implements Indicavel{
    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Ator(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.elegivel = true;

    }
    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getNacionalidade() {return nacionalidade;}

    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}

    @Override
    public boolean isElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(boolean elegivel) {
        this.elegivel = elegivel;
    }

    @Override
    public short getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }

    @Override
    public void incrementarNumeroDeIndicacoes() {
        this.numeroDeIndicacoes++;
    }
}

