package com.br.zup;

import java.util.Scanner;

public class IO {
    public static String pegarLinha() {
        return new Scanner(System.in).nextLine();
    }

    public static int pegarInt() {
        return new Scanner(System.in).nextInt();
    }

    public static double pegarDouble() {
        return new Scanner(System.in).nextDouble();
    }

    public static void mostrar(String mensagem) {
        System.out.println(mensagem);
    }
}
