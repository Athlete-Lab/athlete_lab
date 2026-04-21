package main;

import model.Usuario;
import controller.UsuarioController;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioController controller = new UsuarioController();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    Usuario u = new Usuario();

                    System.out.print("ID: ");
                    u.setIdUsuario(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome: ");
                    u.setNome(sc.nextLine());

                    System.out.print("Email: ");
                    u.setEmail(sc.nextLine());

                    System.out.print("Telefone: ");
                    u.setTelefone(sc.nextLine());

                    System.out.print("Cidade/UF: ");
                    u.setCidadeUF(sc.nextLine());

                    System.out.print("Senha: ");
                    u.setSenha(sc.nextLine());

                    System.out.print("Data de nascimento (dd/MM/yyyy): ");
                    String dataStr = sc.nextLine();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        u.setDataNascimento(sdf.parse(dataStr));
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                        u.setDataNascimento(new Date());
                    }

                    controller.cadastrar(u);
                    break;

                case 2:
                    controller.listar();
                    break;

                case 3:
                    System.out.print("Digite o ID: ");
                    int idBusca = sc.nextInt();

                    Usuario encontrado = controller.buscarPorId(idBusca);

                    if (encontrado != null) {
                        System.out.println("Usuário encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID para deletar: ");
                    int idDel = sc.nextInt();
                    controller.deletar(idDel);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}