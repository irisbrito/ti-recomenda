package com.br.zup;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Filme que contem os atributos, o construtor e os getters e setters
 */

public class Filme {
    private String titulo;
    private String genero;
    private List<String> emailDeQuemIndicou;
    private String email;
    private List<Filme> minhasrecomendacoes = new ArrayList<>();
    private static Catalogo catalogo = new Catalogo();

    public Filme(String titulo, String genero, String email) {
        this.titulo = titulo;
        this.genero = genero;
        this.email = email;
        this.emailDeQuemIndicou = new ArrayList<>();
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

    public List<String> getEmailDeQuemIndicou() {
        return emailDeQuemIndicou;
    }

    public void setEmailDeQuemIndicou(List<String> emailDeQuemIndicou) {
        this.emailDeQuemIndicou = emailDeQuemIndicou;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();
        construtor.append("Título do filme: " + titulo);
        construtor.append("Gênero: " + genero);
        construtor.append("Quem recomendou: " + email);

        return construtor.toString();
    }
    }





