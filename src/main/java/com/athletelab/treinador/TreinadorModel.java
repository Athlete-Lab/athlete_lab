package com.athletelab.treinador;
import com.athletelab.perfilTreinador.PerfilTreinadorModel;
import com.athletelab.usuario.UsuarioModel;

public class TreinadorModel extends UsuarioModel {
    private int idTreinado;
    private boolean ativo;
    private PerfilTreinadorModel perfil; // Composição do Perfil


    public TreinadorModel() {
        super();
        this.perfil = new PerfilTreinadorModel();
    }

    // Getters e Setters
    public int getIdTreinado() { return idTreinado; }
    public void setIdTreinado(int idTreinado) { this.idTreinado = idTreinado; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public PerfilTreinadorModel getPerfil() { return perfil; }
    public void setPerfil(PerfilTreinadorModel perfil) { this.perfil = perfil; }

}

