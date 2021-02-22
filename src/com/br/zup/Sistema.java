package com.br.zup;

import java.util.Scanner;

public class Sistema {
    private static boolean continuaExecutando;

    private static void imprimirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar uma recomendação");
        System.out.println("2. Apagar uma recomendação");
        System.out.println("3. Criar um usuário");
        System.out.println("4. Visualizar as recomendações cadastradas");
        System.out.println("5. Sair:");
    }

    private static void adicionarRecomendacao() {
    }

    private static void apagarRecomendacao() {
    }

    private static void adicionarUsuario() {
    }

    private static void visualizarRecomendacoes() {
    }

    private static void menu() {
        imprimirMenu();

        int opcao = new Scanner(System.in).nextInt();

        if (opcao == 1) {
            adicionarRecomendacao();
        } else if (opcao == 2) {
            apagarRecomendacao();
        } else if (opcao == 3) {
            adicionarUsuario();
        } else if (opcao == 4) {
            visualizarRecomendacoes();
        } else if (opcao == 5) {
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
