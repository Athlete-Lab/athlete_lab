package com.athletelab.equipe;

public class EquipeModel {
    private int idEquipe;
    private String nome;
    private int quantidadeMembros;
    private int idTreinador; // Relacionamento com o Treinador

    public EquipeModel() {}

    public EquipeModel(int idEquipe, String nome, int quantidadeMembros, int idTreinador) {
        this.idEquipe = idEquipe;
        this.nome = nome;
        this.quantidadeMembros = quantidadeMembros;
        this.idTreinador = idTreinador;
    }

    // Getters e Setters
    public int getIdEquipe() { return idEquipe; }
    public void setIdEquipe(int idEquipe) { this.idEquipe = idEquipe; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidadeMembros() { return quantidadeMembros; }
    public void setQuantidadeMembros(int quantidadeMembros) { this.quantidadeMembros = quantidadeMembros; }

    public int getIdTreinador() { return idTreinador; }
    public void setIdTreinador(int idTreinador) { this.idTreinador = idTreinador; }
}
