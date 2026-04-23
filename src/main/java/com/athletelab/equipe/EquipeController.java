package com.athletelab.equipe;

import java.util.List;

import com.athletelab.treinador.*;

public class EquipeController {

    private EquipeDao equipeDao = new EquipeDao();


    public void criarEquipe(String nome, int quantidade, int idTreinado) {
        EquipeModel equipe = new EquipeModel();
        equipe.setNome(nome);
        equipe.setQuantidadeMembros(quantidade);
        equipe.setIdTreinador(idTreinado);
        equipeDao.inserir(equipe);
    }


    public void listarEquipesDoTreinador(int idTreinado) {
        List<EquipeModel> equipes = equipeDao.listarPorTreinador(idTreinado);
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe encontrada para este treinador.");
        } else {
            for (EquipeModel e : equipes) {
                System.out.println("ID: " + e.getIdEquipe() + " | Nome: " + e.getNome());
            }
        }
    }


    public EquipeModel buscarEquipePorId(int id) {
        return equipeDao.buscarPorId(id);
    }


    public void atualizarEquipe(int id, String nome, int quantidade) {
        EquipeModel e = new EquipeModel();
        e.setIdEquipe(id);
        e.setNome(nome);
        e.setQuantidadeMembros(quantidade);
        equipeDao.atualizar(e);
    }


    public void deletarEquipe(int id) {
        equipeDao.deletar(id);
    }

    public void exibirTodasAsEquipes() {
        List<EquipeModel> lista = equipeDao.listarTodas();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada no sistema.");
        } else {
            System.out.println("--- TODAS AS EQUIPES DO SISTEMA ---");
            for (EquipeModel e : lista) {
                System.out.println("ID: " + e.getIdEquipe() + " | Nome: " + e.getNome());
            }
        }
    }
}
