package com.athletelab.usuario;

import java.time.LocalDate;
import java.util.Scanner;
import com.athletelab.usuario.UsuarioController;

public class UsuarioView {

    private Scanner input;
    private UsuarioController controller;

    public UsuarioView(){
        input = new Scanner(System.in);
        controller = new UsuarioController();
    }

    public void menuUsuario(){

        int menuOpcao;

        do {
            System.out.println("====== MENU ====== ");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar");
            System.out.println("0 - Sair do Sistema");
            System.out.println("===================");

            try {
                menuOpcao = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException erro){
                System.out.println("Digite um número válido.");
                menuOpcao = -1;
            }

            switch (menuOpcao){
                case 1:
                    login();
                    break;
                case 2:
                    fazerCadastro();;
                    break;
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Valor não existente como opção.");
            }
        }while(menuOpcao != 0);
    }

    public void login(){
        System.out.print("Digite o e-mail: ");
        String email = input.nextLine();

        System.out.println();

        System.out.print("Digite sua senha: ");
        String senha = input.nextLine();

        UsuarioModel usuario =  controller.login(email, senha);

        if (usuario == null){
            System.out.println("Email ou senha inválidos.");
            return;
        }
        else if (usuario.getTipoUsuario().equals("TREINADOR")){
            System.out.println("Login como Treinador.");
            menuTreinador();
        }
        else if (usuario.getTipoUsuario().equals("ATLETA")){
            System.out.println("Login como Atleta.");
            menuAtleta();
        }

    }


    public void fazerCadastro() {

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Senha: ");
        String senha = input.nextLine();

        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        System.out.println("Tipo de usuário:");
        System.out.println("1 - Treinador");
        System.out.println("2 - Atleta");
        int opcaoTipo = Integer.parseInt(input.nextLine());

        String tipoUsuario;
        if (opcaoTipo == 1) {
            tipoUsuario = "TREINADOR";
        } else {
            tipoUsuario = "ATLETA";
        }

        System.out.print("Cidade/UF: ");
        String cidadeUF = input.nextLine();

        System.out.print("Ano nascimento: ");
        int ano = Integer.parseInt(input.nextLine());

        System.out.print("Mes: ");
        int mes = Integer.parseInt(input.nextLine());

        System.out.print("Dia: ");
        int dia = Integer.parseInt(input.nextLine());

        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

        UsuarioModel usuario = new UsuarioModel(nome, email, senha, telefone, dataNascimento, cidadeUF, tipoUsuario);
        controller.cadastrar(usuario);
    }

    public void menuTreinador(){
        System.out.println("Menu treinador");
    }

    public void menuAtleta(){
        System.out.println("Menu Atleta");
    }
}

