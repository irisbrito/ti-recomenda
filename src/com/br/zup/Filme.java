package com.br.zup;

import java.util.List;
import java.util.Map;

public class Filme {
    private String titulo;
    private String genero;
    private List <String> emailDeQuemIndicou;
    private String email;

    public Filme(String titulo, String genero, String emailDeQuemIndicou) {
        this.titulo = titulo;
        this.genero = genero;
        this.email = email;
        //this.emailDeQuemIndicou = emailDeQuemIndicou;
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

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();
        construtor.append("Título do filme: " + titulo);
        construtor.append("Gênero: " + genero);
        construtor.append("Quem recomendou: " + email);

        return construtor.toString();
    }
}
