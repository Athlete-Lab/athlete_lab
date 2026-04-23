package com.athletelab.perfilTreinador;

public class PerfilTreinadorController {
    private PerfilTreinadorDao perfilDao;

    public PerfilTreinadorController() {
        this.perfilDao = new PerfilTreinadorDao();
    }

    public void salvarPerfil(PerfilTreinadorModel perfil, int idTreinador) {
        if (perfilDao.buscarPorIdTreinador(idTreinador) == null) {
            perfilDao.salvar(perfil, idTreinador);
            System.out.println("Perfil criado com sucesso!");
        } else {
            perfilDao.atualizar(perfil, idTreinador);
            System.out.println(" Perfil atualizado com sucesso!");
        }
    }

    public PerfilTreinadorModel obterPerfil(int idTreinador) {
        return perfilDao.buscarPorIdTreinador(idTreinador);
    }
}
