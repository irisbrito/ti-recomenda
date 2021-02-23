package com.br.zup;

import java.util.Scanner;

public class Sistema {
    private static boolean continuaExecutando;

    private static void imprimirMenu() {
        IO.mostrar("Escolha uma opção:");
        IO.mostrar("1. Adicionar uma recomendação");
        IO.mostrar("2. Apagar uma recomendação");
        IO.mostrar("3. Criar um usuário");
        IO.mostrar("4. Adicionar aos seus favoritos");
        IO.mostrar("5. Visualizar as recomendações cadastradas");
        IO.mostrar("6. Sair:");

    }

    private static void adicionarRecomendacao() {
    }

    private static void apagarRecomendacao() {
    }

    private static void adicionarUsuario() {
    }

    private static void visualizarRecomendacoes() {
    }

    private static void adicionarAosSeusFavoritos() {
    }

    private static void menu() {
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

    public static void executarSistema() {
        continuaExecutando = true;

        while (continuaExecutando) {
            menu();
        }
    }
}
