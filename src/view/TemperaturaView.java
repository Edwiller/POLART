package view;

import control.TemperaturaController;
import exception.TemperaturaException;
import model.Temperatura;
import util.Console;

public class TemperaturaView {

    private final TemperaturaController controller;

    public TemperaturaView(TemperaturaController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            Console.titulo("GERENCIAMENTO DE TEMPERATURAS");

            System.out.println("1 - Registrar Temperatura");
            System.out.println("2 - Histórico");
            System.out.println("0 - Voltar");

            System.out.print("\nOpção: ");

            try {
                opcao = Integer.parseInt(Console.scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    registrar();
                    break;

                case 2:
                    listar();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    Console.pausa();

            }

        } while (opcao != 0);

    }

    private void registrar() {

        try {

            Console.titulo("REGISTRAR TEMPERATURA");

            System.out.print("ID: ");
            Integer id = Integer.parseInt(Console.scanner.nextLine());

            System.out.print("ID do Sensor: ");
            Integer idSensor = Integer.parseInt(Console.scanner.nextLine());

            System.out.print("Temperatura: ");
            double valor = Double.parseDouble(Console.scanner.nextLine());

            Temperatura temperatura = new Temperatura(id, idSensor, valor);

            controller.registrarTemperatura(temperatura);

            System.out.println("\nTemperatura registrada com sucesso!");

        } catch (TemperaturaException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Dados inválidos.");

        }

        Console.pausa();

    }

    private void listar() {

        Console.titulo("HISTÓRICO DE TEMPERATURAS");

        if (controller.listarTemperaturas().isEmpty()) {

            System.out.println("Nenhum registro encontrado.");

        } else {

            controller.listarTemperaturas().forEach(System.out::println);

        }

        Console.pausa();

    }

}