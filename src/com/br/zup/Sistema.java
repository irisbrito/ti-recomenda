package com.br.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que gerencia todas as partes do sistema
 *
 */
public class Sistema {
    private static ValidaEmail validaEmail = new ValidaEmail();
    private static boolean continuaExecutando;
    private static Catalogo catalogo = new Catalogo();
    private static MeusFavoritos meusfilmesfavoritos = new MeusFavoritos();

    /**
     * Imprime o menu de opções para o usuário
     *
     */
    private static void imprimirMenu() {
        IO.mostrar("Escolha uma opção:");
        IO.mostrar("1. Adicionar uma recomendação");
        IO.mostrar("2. Apagar uma recomendação");
        IO.mostrar("3. Criar um usuário");
        IO.mostrar("4. Adicionar aos seus favoritos");
        IO.mostrar("5. Visualizar as recomendações cadastradas");
        IO.mostrar("6. Sair:");

    }

    /**
     * Pergunta o email para o usuário
     *
     * @return uma string com o email
     * @throws Exception quando o email digitado pelo usuário não é válido
     */
    private static String perguntarEmail() throws Exception {
        IO.mostrar("Digite email");
        String email = IO.pegarLinha();
        validaEmail.isEmailvalido(email);
        return email;
    }

    /**
     * Pergunta para o usuário os dados e adiciona uma recomendação na lista de recomendações do sistema
     *
     * @return um objeto filme adicionado no sistema
     * @throws Exception quando o email do usuário não é válido
     */
    public static Filme adicionarRecomendacao() throws Exception {
        String email = perguntarEmail();
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme = catalogo.adicionarFilme(titulo,genero,email);

        return filme;

    }

    /**
     * Apaga uma recomendação do sistema
     *
     * @throws Exception quando o email do usuário que quer apagar a recomendação não é válido
     */
    private static void apagarRecomendacao() throws Exception {
        String email = perguntarEmail();
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();

        Filme filme = catalogo.removerFilme(titulo);

        IO.mostrar("Filme removido.");

    }

    /**
     * Adiciona um usuário no sistema
     *
     * @throws Exception quando o email que o usuário quer adicionar no sistema não é válido
     */
    private static void adicionarUsuario()throws Exception {
        Usuario novousuario = new Usuario();
        IO.mostrar("Digite seu e-nome: ");
        String nome = IO.pegarLinha();
        String email = perguntarEmail();
        IO.mostrar("Parabéns, usuário cadastrado");
        novousuario.setNome(nome);
        novousuario.setEmail(email);

    }

    /**
     * Mostra as recomendações cadastradas no sistema para o usuário
     *
     */
    private static void visualizarRecomendacoes() {
        IO.mostrar(catalogo.getFilmes().toString());
    }

    private static Filme adicionarAosSeusFavoritos() throws Exception {
        String email = perguntarEmail();
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme = meusfilmesfavoritos.adicionarFilme(titulo,genero,email);

        IO.mostrar("Filme adicionado na sua lista de favoritos.");

        return filme;

    }

    /**
     * Permite ao usuário escolher qual opção ele quer realizar no sistema
     *
     * @throws Exception quando alguma opção que o usuário tentou fazer dá um erro
     */
    private static void menu() throws Exception {
        imprimirMenu();

        int opcao = IO.pegarInt();

        if (opcao == 1) {
            adicionarRecomendacao();
        } else if (opcao == 2) {
            apagarRecomendacao();
        } else if (opcao == 3) {
            adicionarUsuario();
        } else if (opcao == 4) {
            adicionarAosSeusFavoritos();
        } else if (opcao == 5) {
            visualizarRecomendacoes();
        } else if (opcao == 6) {
            continuaExecutando = false;
        }
    }

    /**
     * Executa o sistema propriamente dito
     *
     * @throws Exception caso der algum erro na execução do sistema
     */
    public static void executarSistema() throws Exception {
        continuaExecutando = true;

        while (continuaExecutando) {
            menu();
        }
    }
}
