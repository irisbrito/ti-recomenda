package com.br.zup;

import java.io.FileReader;
import java.io.FileWriter;
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

        Usuario usuario = new Usuario(nome, email);
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

        leitor.close();
        return catalogo;
    }

    private static void salvarUsuarioParaArquivo(FileWriter escritor, Usuario usuario) throws Exception {
        escritor.write(usuario.getNome() + "\n"); // \n para ele pular para a linha seguinte
        escritor.write(usuario.getEmail() + "\n");
    }

    public static void salvarListaDeUsuariosParaArquivo(String nomeDoArquivo, ListaDeUsuarios listaDeUsuarios)throws Exception  {
        FileWriter escritor = new FileWriter(nomeDoArquivo);

        for (Usuario usuario: listaDeUsuarios.getUsuarios()) {
            salvarUsuarioParaArquivo(escritor, usuario);
        }

        escritor.close();
    }

    private static void salvarFilmeParaArquivo(FileWriter escritor, Filme filme)throws Exception  {
        escritor.write(filme.getTitulo() + "\n");
        escritor.write(filme.getGenero() + "\n");
        escritor.write(filme.getEmail() + "\n");
    }

    public static void salvarCatalogoParaArquivo(String nomeDoArquivo, Catalogo catalogo) throws Exception {
        FileWriter escritor = new FileWriter(nomeDoArquivo);

        for (Filme filme: catalogo.getFilmes()) {
            salvarFilmeParaArquivo(escritor, filme);
        }

        escritor.close();
    }
}