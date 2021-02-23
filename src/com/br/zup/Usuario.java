package com.br.zup;

public class Usuario {
    private String nome;
    private String email;
    private MeusFavoritos meusFavoritos;

    public Usuario() {

    }

    public boolean validaEmail() throws Exception {

        ValidaEmail valida = new ValidaEmail();
        return valida.isEmailvalido(email);
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

}


