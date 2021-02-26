package com.br.zup;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Classe que lida com o salvamento dos catálogos e usuários em arquivo .txt
 *
 */
public class BancoDeDados {
    /**
     * Lê um filme de um arquivo
     *
     * @param scanner o scanner que lê as linhas do arquivo
     * @return um objeto Filme com o filme lido do arquivo
     */
    private static Filme lerFilmeDoArquivo(Scanner scanner) {
        String titulo = scanner.nextLine();
        String genero = scanner.nextLine();
        String email = scanner.nextLine();

        return new Filme(titulo, genero, email);
    }

    /**
     * Lê um usuário do arquivo
     *
     * @param scanner o scanner que faz a leitura do arquivo
     * @return um objeto usuário com o usuário lido
     */
    private static Usuario lerUsuarioDoArquivo(Scanner scanner) {
        String nome = scanner.nextLine();
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        return usuario;
    }

    /**
     * Lê um arquivo contendo a lista completa de usuários
     *
     * @param nomeDoArquivo uma string com o nome do arquivo onde está a lista
     * @return um objeto ListaDeUsuarios contendo a lista de usuários lida do arquivo
     * @throws Exception caso o arquivo não consiga ser lido ou existam usuários duplicados no arquivo
     */
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

    /**
     * Lê um arquivo contendo um catálogo completo
     *
     * @param nomeDoArquivo uma string contendo o nome do arquivo com o catálogo
     * @return um objeto Catalogo contendo o catálogo lido
     * @throws Exception caso o catálogo contenha filmes duplicados ou o arquivo não consiga ser lido
     */
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

    /**
     * Salva um usuário no arquivo
     *
     * @param escritor um objeto FileWriter que vai escrever os dados do usuário no arquivo
     * @param usuario o usuário que vai ser salvo
     * @throws Exception caso o usuário não consiga ser salvo no arquivo
     */
    private static void salvarUsuarioParaArquivo(FileWriter escritor, Usuario usuario) throws Exception {
        escritor.write(usuario.getNome() + "\n"); // \n para ele pular para a linha seguinte
        escritor.write(usuario.getEmail() + "\n");
    }

    /**
     * Salva uma lista de vários usuários para um arquivo
     *
     * @param nomeDoArquivo uma string com o nome do arquivo para salvar a lista
     * @param listaDeUsuarios  a lista que será salva
     * @throws Exception caso não seja possível salvar a lista no arquivo
     */
    public static void salvarListaDeUsuariosParaArquivo(String nomeDoArquivo, ListaDeUsuarios listaDeUsuarios)throws Exception  {
        FileWriter escritor = new FileWriter(nomeDoArquivo);

        for (Usuario usuario: listaDeUsuarios.getUsuarios()) {
            salvarUsuarioParaArquivo(escritor, usuario);
        }

        escritor.close();
    }

    /**
     * Salva um filme para um arquivo
     *
     * @param escritor um objeto FileWriter que vai escrever os dados no arquivo
     * @param filme    um objeto filme contendo o filme que será salvo
     * @throws Exception caso o filme não consiga ser escrito no arquivo
     */
    private static void salvarFilmeParaArquivo(FileWriter escritor, Filme filme)throws Exception  {
        escritor.write(filme.getTitulo() + "\n");
        escritor.write(filme.getGenero() + "\n");
        escritor.write(filme.getEmail() + "\n");
    }

    /**
     * Salva um catálogo de filmes para um arquivo
     *
     * @param nomeDoArquivo uma  string contendo o nome do arquivo para salvar o catálogo
     * @param catalogo      um objeto Catalogo que será salvo
     * @throws Exception caso o catálogo não consiga ser escrito no arquivo
     */
    public static void salvarCatalogoParaArquivo(String nomeDoArquivo, Catalogo catalogo) throws Exception {
        FileWriter escritor = new FileWriter(nomeDoArquivo);

        for (Filme filme: catalogo.getFilmes()) {
            salvarFilmeParaArquivo(escritor, filme);
        }

        escritor.close();
    }
}