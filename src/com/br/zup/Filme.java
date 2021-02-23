package com.br.zup;

import java.util.ArrayList;
import java.util.List;


public class Filme {
    private String titulo;
    private String genero;
    private List <String> emailDeQuemIndicou;
    private String email;

    public Filme(String titulo, String genero) {
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
}
