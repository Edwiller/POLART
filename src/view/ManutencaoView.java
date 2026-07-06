package view;

import control.ManutencaoController;
import exception.ManutencaoException;
import model.Manutencao;
import util.Console;

public class ManutencaoView {

    private final ManutencaoController controller;

    public ManutencaoView(ManutencaoController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            Console.titulo("GERENCIAMENTO DE MANUTENÇÕES");

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            System.out.print("\nOpção: ");

            try {
                opcao = Integer.parseInt(Console.scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    atualizar();
                    break;

                case 4:
                    remover();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    Console.pausa();

            }

        } while (opcao != 0);

    }

    private void cadastrar() {

        try {

            Console.titulo("CADASTRAR MANUTENÇÃO");

            System.out.print("ID: ");
            Integer id = Integer.parseInt(Console.scanner.nextLine());

            System.out.print("Descrição: ");
            String descricao = Console.scanner.nextLine();

            Manutencao manutencao = new Manutencao(id, id, descricao, null);

            controller.cadastrarManutencao(manutencao);

            System.out.println("Manutenção cadastrada com sucesso!");

        } catch (ManutencaoException e) {

            System.out.println(e.getMessage());

        }

        Console.pausa();

    }

    private void listar() {

        Console.titulo("MANUTENÇÕES");

        if (controller.listarManutencoes().isEmpty()) {

            System.out.println("Nenhuma manutenção cadastrada.");

        } else {

            controller.listarManutencoes().forEach(System.out::println);

        }

        Console.pausa();

    }

    private void atualizar() {

        try {

            Console.titulo("ATUALIZAR MANUTENÇÃO");

            System.out.print("ID: ");
            Integer id = Integer.parseInt(Console.scanner.nextLine());

            System.out.print("Nova descrição: ");
            String descricao = Console.scanner.nextLine();

            Manutencao manutencao = new Manutencao(id, id, descricao, null);

            controller.atualizarManutencao(manutencao);

            System.out.println("Manutenção atualizada com sucesso!");

        } catch (ManutencaoException e) {

            System.out.println(e.getMessage());

        }

        Console.pausa();

    }

    private void remover() {

        try {

            Console.titulo("REMOVER MANUTENÇÃO");

            System.out.print("ID: ");

            Integer id = Integer.parseInt(Console.scanner.nextLine());

            controller.removerManutencao(id);

            System.out.println("Manutenção removida com sucesso!");

        } catch (ManutencaoException e) {

            System.out.println(e.getMessage());

        }

        Console.pausa();

    }

}