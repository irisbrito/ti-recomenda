package com.br.zup;

public class Usuario {
    private String nome;
    private String email;
    private MeusFavoritos meusFavoritos;

    public Usuario() {
        meusFavoritos = new MeusFavoritos();
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

    public MeusFavoritos getMeusFavoritos() {
        return meusFavoritos;
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();

        construtor.append("Nome: " + nome);
        construtor.append("E-mail: " + email);

        return construtor.toString();
    }


}


