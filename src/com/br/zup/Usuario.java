package com.br.zup;

/**
 *  Classe com os atributos e getters e setters do usuário
 */
public class Usuario {
    private String nome;
    private String email;
    private Catalogo meusFavoritos;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        meusFavoritos = new Catalogo();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Catalogo getMeusFavoritos() {
        return meusFavoritos;
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();

        construtor.append("\nNome: " + nome);
        construtor.append("\nE-mail: " + email);

        return construtor.toString();
    }


}


