package com.br.zup;

import java.util.Scanner;

public class Sistema {
    private static ValidaEmail validaEmail = new ValidaEmail();
    private static boolean continuaExecutando;
    private static Catalogo catalogo = new Catalogo();


    private static void imprimirMenu() {
        IO.mostrar("Escolha uma opção:");
        IO.mostrar("1. Adicionar uma recomendação");
        IO.mostrar("2. Apagar uma recomendação");
        IO.mostrar("3. Criar um usuário");
        IO.mostrar("4. Adicionar aos seus favoritos");
        IO.mostrar("5. Visualizar as recomendações cadastradas");
        IO.mostrar("6. Sair:");

    }

    public static Filme adicionarRecomendacao() throws Exception {
        IO.mostrar("Digite email");
        String email = IO.pegarLinha();
        validaEmail.isEmailvalido(email);
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme = catalogo.adicionarFilme(titulo,genero,email);

        return filme;

    }

    private static void apagarRecomendacao() {
    }

    private static void adicionarUsuario()throws Exception {
        Usuario novousuario = new Usuario();
        IO.mostrar("Digite seu e-nome: ");
        String nome = IO.pegarLinha();
        IO.mostrar("Digite seu e-mail: ");
        String email =IO.pegarLinha();
        validaEmail.isEmailvalido(email);
        IO.mostrar("Parabéns, usuário cadastrado");
        novousuario.setNome(nome);
        novousuario.setEmail(email);

    }

    private static void visualizarRecomendacoes() {
        IO.mostrar(catalogo.getFilmes().toString());
    }

    private static void adicionarAosSeusFavoritos() {
    }

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

    public static void executarSistema() throws Exception {
        continuaExecutando = true;

        while (continuaExecutando) {
            menu();
        }
    }
}
