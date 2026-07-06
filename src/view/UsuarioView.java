package view;

import control.UsuarioController;
import exception.UsuarioException;
import model.Administrador;
import model.Operador;
import model.Usuario;
import util.Console;

public class UsuarioView extends Baseview  {

    private final UsuarioController controller;

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {

            titulo("GERENCIAMENTO DE USUÁRIOS");

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
                    System.out.println("\nOpção inválida.");
                    pausa();
            }

        } while (opcao != 0);

    }

    private void cadastrar() {

        try {

            titulo("CADASTRAR USUÁRIO");

            System.out.println("1 - Administrador");
            System.out.println("2 - Operador");

            int tipo = lerInteiro("Tipo: ");

            Integer id = lerInteiro("ID: ");

            String nome = lerTexto("Nome: ");

            String email = lerTexto("Email: ");

            String senha = lerTexto("Senha: ");

            Usuario usuario;

            if (tipo == 1) {

                usuario = new Administrador(
                        id,
                        nome,
                        email,
                        senha
                );

            } else if (tipo == 2) {

                usuario = new Operador(
                        id,
                        nome,
                        email,
                        senha
                );

            } else {

                System.out.println("Tipo inválido.");
                Console.pausa();
                return;

            }

            controller.cadastrarUsuario(usuario);

            sucesso("Usuário cadastrado com sucesso!");

        } catch (UsuarioException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("\nEntrada inválida.");

        }

        pausa();

    }

    private void listar() {

        titulo("LISTA DE USUÁRIOS");

        if (controller.listarUsuarios().isEmpty()) {

            System.out.println("Nenhum usuário cadastrado.");

        } else {

            for (Usuario usuario : controller.listarUsuarios()) {

                System.out.println(usuario);

            }

        }

        pausa();

    }

    private void buscar() {

        titulo("BUSCAR USUÁRIO");

        try {

            System.out.print("Informe o ID: ");

            Integer id = lerInteiro("Informe o ID: ");

            Usuario usuario = controller.buscarUsuario(id);

            if (usuario == null) {

                System.out.println("Usuário não encontrado.");

            } else {

                System.out.println(usuario);

            }

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        pausa();

    }

    private void atualizar() {

        titulo("ATUALIZAR USUÁRIO");

        try {

            System.out.print("ID: ");
            Integer id = lerInteiro("ID: ");

            Usuario antigo = controller.buscarUsuario(id);

            if (antigo == null) {

                System.out.println("Usuário não encontrado.");
                pausa();
                return;

            }

            
            String nome = lerTexto("Novo nome: ");
            String email = lerTexto("Novo email: ");
            String senha = lerTexto("Nova senha: ");

            Usuario atualizado;

            if (antigo instanceof Administrador) {

                atualizado = new Administrador(
                        id,
                        nome,
                        email,
                        senha
                );

            } else {

                atualizado = new Operador(
                        id,
                        nome,
                        email,
                        senha
                );

            }

            controller.atualizarUsuario(atualizado);

            sucesso("Usuário atualizado com sucesso!");

        } catch (UsuarioException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("Dados inválidos.");

        }

        pausa();

    }

    private void remover() {

        titulo("REMOVER USUÁRIO");

        try {

            Integer id = lerInteiro("ID: ");

            controller.removerUsuario(id);

            System.out.println("Usuário removido com sucesso!");

        } catch (UsuarioException e) {

            erro(e.getMessage());

        } catch (Exception e) {

            System.out.println("ID inválido.");

        }

        Console.pausa();

    }

}