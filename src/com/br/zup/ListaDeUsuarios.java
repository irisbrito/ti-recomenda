package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ListaDeUsuarios {
    private List<Usuario> usuarios;

    public ListaDeUsuarios() {
        usuarios = new ArrayList<>();
    }

    public Usuario adicionarUsuario(String nome, String email) {
        try {
            Usuario usuario = pesquisarUsuarioPeloEmail(email);
            throw new Exception("Usuário já está na lista.");
        } catch (Exception e) {
            Usuario usuario = new Usuario();

            usuario.setNome(nome);
            usuario.setEmail(email);

            usuarios.add(usuario);
            return usuario;
        }
    }

    public Usuario pesquisarUsuarioPeloEmail(String email) throws Exception {
        for (Usuario usuario : usuarios) {
            if ( usuario.getEmail().equalsIgnoreCase(email) ) {
                return usuario;
            }
        }

        throw new Exception("Usuário não encontrado");
    }

    public void removerUsuarioPeloEmail(String email) throws Exception {
        Usuario usuario = pesquisarUsuarioPeloEmail(email);

        usuarios.remove(usuario);
        }

        public List<Usuario> getUsuarios() {
            return usuarios;
        }

            }

