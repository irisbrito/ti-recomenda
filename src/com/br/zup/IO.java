package com.br.zup;

import java.util.Scanner;

/**
 * Classe que controla mostrar texto na tela e pegar dados do usuário
 *
 */
public class IO {
    /**
     * Pega uma linha qe o usuário digitou do console
     *
     * @return uma string com o que o usuário digitou
     */
    public static String pegarLinha() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Pega um inteiro digitado pelo usuário
     *
     * @return um int contendo o número que o usuário digitou
     */
    public static int pegarInt() {
        return new Scanner(System.in).nextInt();
    }

    /**
     * * Pega um double digitado pelo usuário
     *
     * @return um double contendo o número que o usuário digitou
     */
    public static double pegarDouble() {
        return new Scanner(System.in).nextDouble();
    }

    /**
     * Mostra uma mensagem na tela
     *
     * @param mensagem uma string com a mensagem que deve ser mostrada na tela
     */
    public static void mostrar(String mensagem) {
        System.out.println(mensagem);
    }
}
