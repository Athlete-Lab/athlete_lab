package com.athletelab.treinador;

import com.athletelab.equipe.EquipeView;

import java.util.Scanner;

public class TreinadorView {

    private Scanner scanner;
    private TreinadorController controller;

    public TreinadorView() {
        this.scanner = new Scanner(System.in);
        this.controller = new TreinadorController();
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n------------------------------------");
            System.out.println("       MÓDULO DO TREINADOR");
            System.out.println("------------------------------------");
            System.out.println("1- Cadastrar Perfil Treinador");
            System.out.println("2- Criar Nova Equipe");
            System.out.println("3- Listar Minhas Equipes");
            System.out.println("4- Gerenciar Atletas");
            System.out.println("5- Atualizar Ranking");
            System.out.println("0- Voltar ao Menu Principal");
            System.out.print(" Escolha uma opção: ");

            try {
                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    continue; // Resolve o "vazio" inicial do Docker
                }

                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas o número da opção.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarTreinadorView();
                    break;
                case 2:
                    EquipeView ev = new EquipeView();
                    ev.exibirFormularioCadastro();
                    break;
                case 3:
                    controller.listarEquipe();
                    break;
                case 4:
                    controller.gerenciarAtletas();
                    break;
                case 5:
                    controller.atualizarRanking();
                    break;
                case 0:
                    System.out.println("Saindo do módulo de Treinador...");
                    break;
                default:
                    System.out.println(" Opção inválida!");
                    break;
            }
        }
    }

    private void cadastrarTreinadorView() {
        TreinadorModel t = new TreinadorModel();

        System.out.println("\n--- Cadastro de Perfil de Treinador ---");


        System.out.print("Informe seu ID de Usuário: ");
        try {
            t.setIdUsuario(Integer.parseInt(scanner.nextLine().trim()));
        } catch (Exception e) {
            System.out.println("⚠ ID inválido!");
            return;
        }

        System.out.print("Definir como ativo? (S/N): ");
        String status = scanner.nextLine().trim();
        t.setAtivo(status.equalsIgnoreCase("S"));

        // Chamando o Controller para salvar no banco
        controller.cadastrar(t);
    }
}
