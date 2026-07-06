package view;

import control.SensorController;
import exception.SensorException;
import model.Sensor;
import util.Console;

public class SensorView {

    private final SensorController controller;

    public SensorView(SensorController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            Console.titulo("GERENCIAMENTO DE SENSORES");

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

            Console.titulo("CADASTRAR SENSOR");

            System.out.print("ID: ");
            Integer id = Integer.parseInt(Console.scanner.nextLine());

            System.out.print("Código: ");
            String codigo = Console.scanner.nextLine();

            System.out.print("Modelo: ");
            String modelo = Console.scanner.nextLine();

            System.out.print("ID da Sala: ");
            Integer idSala = Integer.parseInt(Console.scanner.nextLine());

            Sensor sensor = new Sensor(
                    id,
                    codigo,
                    modelo,
                    idSala
            );

            controller.cadastrarSensor(sensor);

            System.out.println("\nSensor cadastrado com sucesso!");

        } catch (SensorException e) {

            System.out.println("\nErro: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("\nDados inválidos.");

        }

        Console.pausa();

    }

    private void listar() {

        Console.titulo("SENSORES CADASTRADOS");

        if (controller.listarSensores().isEmpty()) {

            System.out.println("Nenhum sensor cadastrado.");

        } else {

            controller.listarSensores().forEach(System.out::println);

        }

        Console.pausa();

    }

    private void buscar() {

        Console.titulo("BUSCAR SENSOR");

        try {

            System.out.print("Informe o ID: ");

            Integer id = Integer.parseInt(Console.scanner.nextLine());

            Sensor sensor = controller.buscarSensor(id);

            if (sensor == null) {

                System.out.println("Sensor não encontrado.");

            } else {

                System.out.println(sensor);

            }

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        Console.pausa();

    }

    private void atualizar() {

        Console.titulo("ATUALIZAR SENSOR");

        try {

            System.out.print("ID: ");
            Integer id = Integer.parseInt(Console.scanner.nextLine());

            Sensor antigo = controller.buscarSensor(id);

            if (antigo == null) {

                System.out.println("Sensor não encontrado.");
                Console.pausa();
                return;

            }

            System.out.print("Novo código: ");
            String codigo = Console.scanner.nextLine();

            System.out.print("Novo modelo: ");
            String modelo = Console.scanner.nextLine();

            System.out.print("Novo ID da Sala: ");
            Integer idSala = Integer.parseInt(Console.scanner.nextLine());

            Sensor atualizado = new Sensor(
                    id,
                    codigo,
                    modelo,
                    idSala
            );

            controller.atualizarSensor(atualizado);

            System.out.println("Sensor atualizado com sucesso!");

        } catch (SensorException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Dados inválidos.");

        }

        Console.pausa();

    }

    private void remover() {

        Console.titulo("REMOVER SENSOR");

        try {

            System.out.print("ID: ");

            Integer id = Integer.parseInt(Console.scanner.nextLine());

            controller.removerSensor(id);

            System.out.println("Sensor removido com sucesso!");

        } catch (SensorException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        Console.pausa();

    }

}