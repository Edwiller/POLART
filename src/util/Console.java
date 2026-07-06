package util;

import java.util.Scanner;

public class Console {

    public static final Scanner scanner = new Scanner(System.in);

    public static void titulo(String titulo) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println(titulo.toUpperCase());
        System.out.println("==========================================");

    }

    public static void pausa() {

        System.out.println();
        System.out.print("Pressione ENTER para continuar...");
        scanner.nextLine();

    }

    public static void linha() {

        System.out.println("------------------------------------------");

    }

}