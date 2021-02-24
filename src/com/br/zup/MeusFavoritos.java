package com.br.zup;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe para criar a lista de filmes favoritos para cada usuario
 */

public class MeusFavoritos extends Catalogo {

    private List<Filme> meusfilmesfavoritos = new ArrayList<>();
    private ValidaEmail validaEmail = new ValidaEmail();
    private static MeusFavoritos favoritos = new MeusFavoritos();

    private static void visualizarFavortitos() {
        IO.mostrar(favoritos.getFilmes().toString());
    }
}

