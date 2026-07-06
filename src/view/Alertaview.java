package view;

import control.AlertaController;
import exception.AlertaException;
import model.Alerta;
import util.Console;

public class AlertaView {

    private final AlertaController controller;

    public AlertaView(AlertaController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            Console.titulo("GERENCIAMENTO DE ALERTAS");

            System.out.println("1 - Listar Alertas");
            System.out.println("2 - Resolver Alerta");
            System.out.println("0 - Voltar");

            System.out.print("\nOpção: ");

            try {
                opcao = Integer.parseInt(Console.scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    listar();
                    break;

                case 2:
                    resolver();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    Console.pausa();

            }

        } while (opcao != 0);

    }

    private void listar() {

        Console.titulo("ALERTAS");

        if (controller.listarAlertas().isEmpty()) {

            System.out.println("Nenhum alerta encontrado.");

        } else {

            controller.listarAlertas().forEach(System.out::println);

        }

        Console.pausa();

    }

    private void resolver() {

        try {

            Console.titulo("RESOLVER ALERTA");

            System.out.print("ID do alerta: ");

            Integer id = Integer.parseInt(Console.scanner.nextLine());

            controller.resolverAlerta(id);

            System.out.println("Alerta resolvido com sucesso!");

        } catch (AlertaException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        Console.pausa();

    }

}