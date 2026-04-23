package com.athletelab.atleta;

import com.athletelab.perfil_atleta.PerfilAtletaModel;
import com.athletelab.usuario.UsuarioModel;
import java.util.List;
import java.util.ArrayList;

public class AtletaModel extends UsuarioModel{
    private int idAtleta;
    private boolean ativo;
    private List<PerfilAtletaModel> perfil;

    public AtletaModel(int idAtleta, boolean ativo) {
        this.idAtleta = idAtleta;
        this.ativo = ativo;
        this.perfil = new ArrayList<>();
    }

    public int getIdAtleta() {
        return idAtleta;
    }
    public void setIdAtleta(int idAtleta) {
        this.idAtleta = idAtleta;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
