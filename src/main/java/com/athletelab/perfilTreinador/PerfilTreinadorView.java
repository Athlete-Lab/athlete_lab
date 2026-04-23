package com.athletelab.perfilTreinador;
import java.util.Scanner;
public class PerfilTreinadorView {

    private PerfilTreinadorController controller;
    private Scanner scanner;

    public PerfilTreinadorView() {
        this.controller = new PerfilTreinadorController();
        this.scanner = new Scanner(System.in);
    }

    public void gerenciarPerfil(int idTreinador) {
        System.out.println("\n--- CONFIGURAÇÃO DE PERFIL DO TREINADOR ---");


        PerfilTreinadorModel perfil = controller.obterPerfil(idTreinador);
        if (perfil == null) {
            perfil = new PerfilTreinadorModel();
            System.out.println("Nenhum perfil encontrado. Vamos criar um novo!");
        } else {
            System.out.println("Editando perfil atual...");
        }

        System.out.print("Modalidade (ex: Musculação, Yoga): ");
        perfil.setModalidade(scanner.nextLine());

        System.out.print("Nível de Experiência (Junior/Pleno/Senior): ");
        perfil.setNivelExperiencia(scanner.nextLine());

        System.out.print("Objetivo Profissional: ");
        perfil.setObjetivo(scanner.nextLine());

        System.out.print("Ambiente de Treino (Interno/Externo): ");
        perfil.setAmbiente(scanner.nextLine());

        System.out.print("Sexo: ");
        perfil.setSexo(scanner.nextLine());

        System.out.print("Restrição Física (se houver): ");
        perfil.setRestricaoFisica(scanner.nextLine());

        controller.salvarPerfil(perfil, idTreinador);
    }
}
