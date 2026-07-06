package view;

import control.SalaController;
import exception.SalaException;
import model.SalaRefrigerada;
import util.Console;

public class SalaView extends Baseview{

    private final SalaController controller;

    public SalaView(SalaController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            titulo("GERENCIAMENTO DE SALAS");

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

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
                    buscar();
                    break;

                case 4:
                    atualizar();
                    break;

                case 5:
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

            Console.titulo("CADASTRAR SALA");

            Integer id = lerInteiro("ID: ");

            String nome = lerTexto("Nome: ");

            String localizacao = lerTexto("localizacao: ");

            double tempMin = lerDouble("Temperatura mínima: ");

            double tempMax = lerDouble("Temperatura máxima: ");
            
            SalaRefrigerada sala = new SalaRefrigerada(id,nome,localizacao,tempMin,tempMax);

            controller.cadastrarSala(sala);

            sucesso("\nSala cadastrada com sucesso!");

        } catch (SalaException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("\nDados inválidos.");

        }

        pausa();

    }

    private void listar() {

        titulo("SALAS CADASTRADAS");

        if (controller.listarSalas().isEmpty()) {

            System.out.println("Nenhuma sala cadastrada.");

        } else {

            controller.listarSalas().forEach(System.out::println);

        }

        pausa();

    }

    private void buscar() {

        titulo("BUSCAR SALA");

        try {

            Integer id = lerInteiro("ID: ");

            SalaRefrigerada sala = controller.buscarSala(id);

            if (sala == null) {

                System.out.println("Sala não encontrada.");

            } else {

                System.out.println(sala);

            }

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        pausa();

    }

    private void atualizar() {

        titulo("ATUALIZAR SALA");

        try {

            Integer id = lerInteiro("ID: ");

            SalaRefrigerada sala = controller.buscarSala(id);

            if (sala == null) {

                System.out.println("Sala não encontrada.");
                pausa();
                return;

            }

            System.out.print("Novo nome: ");
            String nome = Console.scanner.nextLine();

            System.out.print("Nova localização: ");
            String localizacao = Console.scanner.nextLine();

            System.out.print("Nova temperatura mínima: ");
            double tempMin = Double.parseDouble(Console.scanner.nextLine());

            System.out.print("Nova temperatura máxima: ");
            double tempMax = Double.parseDouble(Console.scanner.nextLine());

            SalaRefrigerada atualizada = new SalaRefrigerada(id,nome,localizacao,tempMin,tempMax);

            controller.atualizarSala(atualizada);

            System.out.println("Sala atualizada com sucesso!");

        } catch (SalaException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("Dados inválidos.");

        }

        Console.pausa();

    }

    private void remover() {

        titulo("REMOVER SALA");

        try {

            Integer id = lerInteiro("ID: ");

            controller.removerSala(id);

            sucesso("Sala removida com sucesso!");

        } catch (SalaException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        pausa();

    }

}