package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Filme> listaDeFilmes = new ArrayList<>();
    private  String email;

    public Filme adicionarFilme(String titulo, String genero, String email) throws Exception {

        if(!email.contains("@")){
            throw new Exception("Email invalido");
        }
        Filme filme = new Filme(titulo, genero);
        listaDeFilmes.add(filme);

        return filme;
    }

    public Filme pesquisarFilme(String nomeDoFilme) throws Exception {
        for (int i = 0; i < listaDeFilmes.size(); i++) {
            Filme filme = listaDeFilmes.get(i);
            if (filme.getTitulo().equals(nomeDoFilme)) {
                return filme;
            }
        }

        throw new Exception("Filme não encontrado");
    }

    public void removerFilme(String nomeDoFilme) throws Exception {
        Filme filme = pesquisarFilme(nomeDoFilme);

        listaDeFilmes.remove(filme);
    }


}
