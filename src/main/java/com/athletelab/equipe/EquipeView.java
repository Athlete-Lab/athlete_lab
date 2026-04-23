package com.athletelab.equipe;

import java.util.Scanner;

public class EquipeView {
    private Scanner scanner = new Scanner(System.in);
    private EquipeController equipeController = new EquipeController();

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== GERENCIAR EQUIPES =====");
            System.out.println("1- Criar Equipe");
            System.out.println("2- Listar Todas as Equipes");
            System.out.println("3- Atualizar Equipe");
            System.out.println("4- Deletar Equipe");
            System.out.println("0- Voltar");
            System.out.print(" Escolha: ");

            try {
                String entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) continue;
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números!");
                continue;
            }

            switch (opcao) {
                case 1:
                    exibirFormularioCadastro();
                    break;
                case 2:
                    equipeController.exibirTodasAsEquipes();
                    break;
                case 3:
                    // Lógica de atualizar...
                    break;
                case 4:
                    // Lógica de deletar...
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println(" Opção inválida.");
            }
        }
    }


    public void exibirFormularioCadastro() {
        System.out.println("\n--- NOVA EQUIPE ---");

        System.out.print("Nome da Equipe: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Quantidade de Membros: ");
        int qtd;
        try {
            qtd = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(" Quantidade inválida. Operação cancelada.");
            return;
        }

        System.out.print("ID do Treinador Responsável: ");
        int idT;
        try {
            idT = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(" ID inválido. Operação cancelada.");
            return;
        }


        equipeController.criarEquipe(nome, qtd, idT);
    }
}
