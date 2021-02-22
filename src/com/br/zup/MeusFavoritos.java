package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class MeusFavoritos {
    private String email;
    private List<Filme> filmesFavoritos = new ArrayList<>();

    public void adicionarFilmeFavorito(Filme filme) {
        filmesFavoritos.add(filme);

    }

    public void removerFilmeFavorito(Filme filme) {
        for(int i=0;i<filmesFavoritos.size();i++){
            Filme e = filmesFavoritos.get(i);
            if (e.getTitulo().equals(filme.getTitulo())) {
                filmesFavoritos.remove(i);
                break;
            }
        }
    }
}
