package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ListaDeUsuarios {
    private List<Usuario> usuarios;
/**
 * A classe ListadeUsuários é uma lista composta com todos os usuários cadastrados na plataforma
 */

    public ListaDeUsuarios() {
        usuarios = new ArrayList<>();
    }
/**
 *  O método adicionarUsuario permite que um novo usuário seja cadastrado no sistema
 */
    public Usuario adicionarUsuario(String nome, String email)throws Exception  {
        try {
            Usuario usuario = pesquisarUsuarioPeloEmail(email);
        } catch (Exception e) {
            Usuario usuario = new Usuario(nome, email);

            usuarios.add(usuario);
            return usuario;
        }

        throw new Exception("Usuário já está na lista.");
    }
    /**
     *  O método pesquisarUsuarioPeloEmail permite a busca por um usuário que já esteja
     *  cadastrado no sistema utilizando o email
     */
    public Usuario pesquisarUsuarioPeloEmail(String email) throws Exception {
        for (Usuario usuario : usuarios) {
            if ( usuario.getEmail().equalsIgnoreCase(email) ) {
                return usuario;
            }
        }

        throw new Exception("Usuário não encontrado");
    }
    /**
     *  O método removerUsuarioPeloEmail permite excluir da base de dados um usuário que já esteja
     *  cadastrado no sistema
     */
    public void removerUsuarioPeloEmail(String email) throws Exception {
        Usuario usuario = pesquisarUsuarioPeloEmail(email);

        usuarios.remove(usuario);
        }
    /**
     *  O método isEmailvalido verifica se o email informado pelo usuário é um email válido
     */
    public static boolean isEmailvalido( String email) throws Exception {
        if (!email.contains("@") && !email.contains(".com")) {
            throw new Exception("E-mail invalido");
        }else{
            return true;
        }
    }
    /**
     *  O método verificarSeEmailEstaCadastrado verifica não permite
     *  que mais de um usuário utilize o mesmo email
     */
    public void verificarSeEmailEstaCadastrado(String email) throws Exception {
        for(Usuario usuario: usuarios){
            if(usuario.getEmail().equals(email)){
                throw new Exception("Email já cadastrado");
            }
        }
    }

    public List <Usuario> getUsuarios() {
        return usuarios;
    }
}

