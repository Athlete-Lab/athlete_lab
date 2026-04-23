package com.athletelab.atleta;

import com.athletelab.perfil_atleta.PerfilAtletaController;
import java.util.Scanner;

public class AtletaView {

    private Scanner input;
    private AtletaController controller;

    public void menuAtleta(){

        int opcaoMenu;

        do{
            System.out.println("==============================");
            System.out.println("        MENU DO ATLETA        ");
            System.out.println("==============================");
            System.out.println("1 - Criar Perfil");
            System.out.println("2 - Atualizar Perfil");
            System.out.println("3 - Visualizar Perfil");
            System.out.println("4 - Visualizar Treino");
            System.out.println("5 - Finalizar Treino");
            System.out.println("6 - Ver Histórico de Treinos");
            System.out.println("7 - Excluir Minha Conta");
            System.out.println("0 - Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = Integer.parseInt(input.nextLine());

            switch (opcaoMenu){
                case 1:
                    CriarPerfil();
                    break;
                case 2:
                    atualizarPerfil();
                    break;
                case 3:
                    alterarSenha();
                    break;
                case 4:
                    visualizarTreino();
                    break;
                case 5:
                    finalarTreino();
                    break;
                case 6:
                    verHistoricoTreinos();
                    break;
                case 7:
                    deletaConta();
                    break;
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Valor não existente como opção.");
            }
        }  while(opcaoMenu != 0);
    }

    private void CriarPerfil(){}

    private void atualizarPerfil(){}

    private void alterarSenha(){}

    private void visualizarTreino(){}

    private void finalarTreino(){}

    private void verHistoricoTreinos(){}

    private void deletaConta(){}


}
