package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Filme implements Indicavel{
    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Filme(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
        this.elegivel = true;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

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
