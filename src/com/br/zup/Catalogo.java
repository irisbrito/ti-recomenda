package com.br.zup;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Catalogo que vai gerenciar o acervo de filmes
 */

public class Catalogo {
    private List<Filme> listaDeFilmes = new ArrayList<>();
    private  String email;
    private ValidaEmail validaEmail = new ValidaEmail();

    /**
     * Método para adicionar Filme às recomendações
     * @param titulo
     * @param genero
     * @param email
     * @return o filme cadastrado
     * @throws Exception
     */

    public Filme adicionarFilme(String titulo, String genero, String email) throws Exception {
        validaEmail.isEmailvalido(email);
        Filme filme = new Filme(titulo, genero, email);
        listaDeFilmes.add(filme);

        return filme;
    }

    /**
     * Método para pesquisar filme de acordo com o título
     * @param nomeDoFilme
     * @return o filme encontrado
     * @throws Exception
     */
    public Filme pesquisarFilme(String nomeDoFilme) throws Exception {
        for (int i = 0; i < listaDeFilmes.size(); i++) {
            Filme filme = listaDeFilmes.get(i);
            if (filme.getTitulo().equals(nomeDoFilme)) {
                return filme;
            }
        }

        throw new Exception("Filme não encontrado");
    }

    /**
     * Método para remover filme do catálogo de recomendações
     * @param nomeDoFilme
     * @return o nome do filme deletado
     * @throws Exception
     */
    public Filme removerFilme(String nomeDoFilme) throws Exception {
        Filme filme = pesquisarFilme(nomeDoFilme);

        listaDeFilmes.remove(filme);
        return filme;
    }

    public List <Filme> getFilmes() {
        return listaDeFilmes;
    }
}
