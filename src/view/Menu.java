package view;

import control.AlertaController;
import control.ManutencaoController;
import control.SalaController;
import control.SensorController;
import control.TemperaturaController;
import control.UsuarioController;
import model.Alerta;
import repository.AlertaRepository;
import repository.ManutencaoRepository;
import repository.SalaRepository;
import repository.SensorRepository;
import repository.TemperaturaRepository;
import repository.UsuarioRepository;

import util.Console;

public class Menu {

    private final UsuarioView usuarioView;
    private final SalaView salaView;
    private final SensorView sensorView;
    private final TemperaturaView temperaturaView;
    private final AlertaView alertaView;
    private final ManutencaoView manutencaoView;

    public Menu() {

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        SalaRepository salaRepository = new SalaRepository();

        SensorRepository sensorRepository = new SensorRepository();

        TemperaturaRepository temperaturaRepository = new TemperaturaRepository();

        AlertaRepository alertaRepository = new AlertaRepository();
        
        ManutencaoRepository manutencaoRepository = new ManutencaoRepository();

        UsuarioController usuarioController = new UsuarioController(usuarioRepository);

        SalaController salaController = new SalaController(salaRepository);

        SensorController sensorController = new SensorController(sensorRepository);

        AlertaController alertaController = new AlertaController(alertaRepository);

        ManutencaoController manutencaoController = new ManutencaoController(manutencaoRepository);

        TemperaturaController temperaturaController = new TemperaturaController(temperaturaRepository,sensorRepository,salaRepository,alertaRepository);


        usuarioView = new UsuarioView(usuarioController);

        salaView = new SalaView(salaController);

        sensorView = new SensorView(sensorController);

        temperaturaView = new TemperaturaView(temperaturaController);

        alertaView = new AlertaView(alertaController);

        manutencaoView = new ManutencaoView(manutencaoController);

    }

    public void iniciar() {

        int opcao;

        do {

            Console.titulo("SISTEMA DE CONTROLE DE SALAS REFRIGERADAS");

            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Salas");
            System.out.println("3 - Gerenciar Sensores");
            System.out.println("4 - Registrar Temperaturas");
            System.out.println("5 - Gerenciar Alertas");
            System.out.println("6 - Gerenciar Manutenções");
            System.out.println("0 - Encerrar");

            System.out.print("\nEscolha uma opção: ");

            try {

                opcao = Integer.parseInt(Console.scanner.nextLine());

            } catch (NumberFormatException e) {

                opcao = -1;

            }

            switch (opcao) {

                case 1:
                    usuarioView.menu();
                    break;

                case 2:
                    salaView.menu();
                    break;

                case 3:
                    sensorView.menu();
                    break;

                case 4:
                    temperaturaView.menu();
                    break;

                case 5:
                    alertaView.menu();
                    break;

                case 6:
                    manutencaoView.menu();
                    break;

                case 0:

                    Console.titulo("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
                    Console.pausa();

            }

        } while (opcao != 0);

    }

}