package view;

import util.Console;

public abstract class Baseview {

    protected void titulo(String titulo) {
        Console.titulo(titulo);
    }

    protected void pausa() {
        Console.pausa();
    }

    protected void linha() {
        Console.linha();
    }

    protected int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                return Integer.parseInt(Console.scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Valor inválido! Digite um número inteiro.");

            }

        }

    }

    protected double lerDouble(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);
                return Double.parseDouble(Console.scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Valor inválido! Digite um número.");

            }

        }

    }

    protected String lerTexto(String mensagem) {

        System.out.print(mensagem);
        return Console.scanner.nextLine();

    }

    protected void sucesso(String mensagem) {

        System.out.println();
        System.out.println("✓ " + mensagem);

    }

    protected void erro(String mensagem) {

        System.out.println();
        System.out.println("✗ " + mensagem);

    }

}