package com.br.zup;

public class Usuario {
    String email;
    String nome;

    public boolean validaEmail() throws Exception {

        ValidaEmail valida = new ValidaEmail();
        return valida.isEmailvalido(email);
    }
}
