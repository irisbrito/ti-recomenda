
package com.br.zup;

/**
 * Classe com todos os atributos do usuário
 **/

public class Usuario {
    private String nome;
    private String email;
    private MeusFavoritos meusFavoritos;

    public Usuario() {

    }

/**
 * Método que verifica se o e-mail do usuário é um e-mail válido
 * */

    public boolean validaEmail() throws Exception {

        ValidaEmail valida = new ValidaEmail();
        return valida.isEmailvalido(email);
    }
/**
 * Getters e Setters dos atributos
 * */

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


