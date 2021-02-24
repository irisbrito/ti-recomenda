package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ListaDeUsuarios {
    private List<Usuario> usuarios;

    public ListaDeUsuarios() {
        usuarios = new ArrayList <>();
    }

    public Usuario adicionarUsuario(String nome, String email)throws Exception  {
        try {
            Usuario usuario = pesquisarUsuarioPeloEmail(email);
        } catch (Exception e) {
            Usuario usuario = new Usuario();

            usuario.setNome(nome);
            usuario.setEmail(email);

            usuarios.add(usuario);
            return usuario;
        }

        throw new Exception("Usuário já está na lista.");
    }

    public Usuario pesquisarUsuarioPeloEmail(String email) throws Exception {
        for (Usuario usuario: usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }

        throw new Exception("Usuário não encontrado");
    }

    public void removerUsuarioPeloEmail(String email) throws Exception {
        Usuario usuario = pesquisarUsuarioPeloEmail(email);

        usuarios.remove(usuario);
    }

    public static boolean isEmailvalido( String email) throws Exception {
        if (!email.contains("@") && !email.contains(".com")) {
            throw new Exception("E-mail invalido");
        }else{
            return true;
        }
    }

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
