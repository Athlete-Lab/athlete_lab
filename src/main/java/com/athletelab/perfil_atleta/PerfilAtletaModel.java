package com.athletelab.perfil_atleta;

public class PerfilAtletaModel {

    private String modalidade;
    private String nivelExperiencia;
    private String objetivo;
    private float altura;
    private float peso;
    private String diasSemana;
    private String tempoTreino;
    private String ambiente;
    private Sexo sexo;
    private String restricao;

    public enum Sexo{
        M , F
    }

    public PerfilAtletaModel(String modalidade, String nivelExperiencia, String objetivo, float altura, float peso, String diasSemana, String tempoTreino, String ambiente, Sexo sexo, String restricao) {
        this.modalidade = modalidade;
        this.nivelExperiencia = nivelExperiencia;
        this.objetivo = objetivo;
        this.altura = altura;
        this.peso = peso;
        this.diasSemana = diasSemana;
        this.tempoTreino = tempoTreino;
        this.ambiente = ambiente;
        this.sexo = sexo;
        this.restricao = restricao;
    }

    public String getModalidade() {
        return modalidade;
    }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }
    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDiasSemana() {
        return diasSemana;
    }
    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getTempoTreino() {
        return tempoTreino;
    }
    public void setTempoTreino(String tempoTreino) {
        this.tempoTreino = tempoTreino;
    }

    public String getAmbiente() {
        return ambiente;
    }
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getRestricao() {
        return restricao;
    }
    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }
}
