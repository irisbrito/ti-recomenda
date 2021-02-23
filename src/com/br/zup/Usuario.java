package com.br.zup;

public class Usuario {
    private String email;
    private String nome;
    private MeusFavoritos meusFavoritos;

    public boolean validaEmail() throws Exception {

        ValidaEmail valida = new ValidaEmail();
        return valida.isEmailvalido(email);
    }
}
