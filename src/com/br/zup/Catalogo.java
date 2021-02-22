package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Filme> listaDeFilmes = new ArrayList<>();
    private String email;


    public Filme adicionarFilme(String titulo, String genero, String email) throws Exception {
        if(!email.contains("@")){
            throw new Exception("Email invalido");
        }
        Filme filme = new Filme(titulo, genero, email);
        listaDeFilmes.add(filme);

        return filme;
    }


}
