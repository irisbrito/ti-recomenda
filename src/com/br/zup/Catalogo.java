package com.br.zup;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Catalogo que vai gerenciar o acervo de filmes
 */

public class Catalogo {
    private List<Filme> listaDeFilmes = new ArrayList<>();

    /**
     * Método para adicionar Filme às recomendações
     * @param titulo
     * @param genero
     * @param email
     * @return o filme cadastrado
     * @throws Exception
     */

    public Filme adicionarFilme(String titulo, String genero, String email) throws Exception {
        ListaDeUsuarios.isEmailvalido(email);
        try{
            Filme filme = pesquisarFilme(titulo);
        } catch (Exception e){
            Filme filme = new Filme(titulo, genero, email);
            listaDeFilmes.add(filme);


            return filme;
        }

        throw new Exception("Filme já cadastrado.");
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
     * O método pega a lista com o gênero desejado pelo usuário
     * @param genero
     * @return lista com os filmes do gênero desejado
     */
    public List<String> pegarFilmesComOGenero(String genero){
        List<String> listaDeFilmesComOGenero = new ArrayList<>();

        for(Filme filme : listaDeFilmes){
            if (filme.getGenero().equalsIgnoreCase(genero)){
                listaDeFilmesComOGenero.add(filme.getTitulo());
            }
        }
        return listaDeFilmesComOGenero;
    }

    /**
     * O método pega a lista de gêneros cadastrados no sistema
     * @return a lista de gêneros existentes no sistema
     */
    public List <String> pegarListaDeGeneros() {
        List <String> listaDeGeneros = new ArrayList<>();

        for (Filme filme: listaDeFilmes) {
            if (!listaDeGeneros.contains(filme.getGenero())) {
                listaDeGeneros.add(filme.getGenero());
            }
        }

        return listaDeGeneros;
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

    /**
     * Método get que retorna a lista de filmes
     * @return listaDeFilmes
     */
    public List <Filme> getFilmes() {
        return listaDeFilmes;
    }

    /**
     * Método para adicionar filme na lista de minhas recomendações à partir do e-mail do usuário
     * @param email
     * @return minhasRecomendacoes
     */
    public List<Filme> minhasRecomendacoes(String email) {
        List<Filme> minhasRecomendacoes = new ArrayList<>();

        for (Filme filme : listaDeFilmes) {
            if (filme.getEmail().equalsIgnoreCase(email)) {
                minhasRecomendacoes.add(filme);
            }
        }

        return minhasRecomendacoes;
    }
}
