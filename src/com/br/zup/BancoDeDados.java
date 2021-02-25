package com.br.zup;

import java.io.FileReader;
import java.util.Scanner;

public class BancoDeDados {
    private static Filme lerFilmeDoArquivo(Scanner scanner) {
        String titulo = scanner.nextLine();
        String genero = scanner.nextLine();
        String email = scanner.nextLine();

        return new Filme(titulo, genero, email);
    }

    private static Usuario lerUsuarioDoArquivo(Scanner scanner) {
        String nome = scanner.nextLine();
        String email = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        return usuario;
    }

    public static ListaDeUsuarios lerListaDeUsuarios(String nomeDoArquivo) throws Exception {
        FileReader leitor = new FileReader(nomeDoArquivo);
        Scanner scanner = new Scanner(leitor);
        ListaDeUsuarios listaDeUsuarios = new ListaDeUsuarios();

        while (scanner.hasNextLine()) {
            Usuario usuario = lerUsuarioDoArquivo(scanner);
            listaDeUsuarios.adicionarUsuario(usuario.getNome(), usuario.getEmail());
        }

        return listaDeUsuarios;
    }

    public static Catalogo lerCatalogoDoArquivo(String nomeDoArquivo) throws Exception {
        FileReader leitor = new FileReader(nomeDoArquivo);
        Scanner scanner = new Scanner(leitor);
        Catalogo catalogo = new Catalogo();

        while (scanner.hasNextLine()) {
            Filme filme = lerFilmeDoArquivo(scanner);
            catalogo.adicionarFilme(filme.getTitulo(), filme.getGenero(), filme.getEmail());
        }

        return catalogo;
    }
}