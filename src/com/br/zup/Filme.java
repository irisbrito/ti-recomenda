package com.br.zup;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Filme que contem os atributos, o construtor e os getters e setters
 */

public class Filme {
    private String titulo;
    private String genero;
    private String email;

    public Filme(String titulo, String genero, String email) {
        this.titulo = titulo;
        this.genero = genero;
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();
        construtor.append("\nTítulo do filme: " + titulo);
        construtor.append("\nGênero: " + genero);
        construtor.append("\nQuem recomendou: " + email);

        return construtor.toString();
    }
    }





