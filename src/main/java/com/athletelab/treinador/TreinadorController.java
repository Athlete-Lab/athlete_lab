package com.athletelab.treinador;

import com.athletelab.equipe.*;
public class TreinadorController {
    private TreinadorDao dao = new TreinadorDao();
    private EquipeDao equipeDao = new EquipeDao();


    public void cadastrar(TreinadorModel t) {
        if (t.getIdUsuario() > 0) {
            dao.inserir(t);
        } else {
            System.out.println("️ Erro: Treinador sem usuário vinculado.");
        }
    }

    public void criarEquipe(String nome, int quantidade, int idTreinado) {
        if (nome == null || nome.isEmpty()) {
            System.out.println(" Erro: A equipe precisa de um nome.");
            return;
        }

        // 2. EMPACOTAMENTO: Criamos o objeto Equipe
        EquipeModel novaEquipe = new EquipeModel();
        novaEquipe.setNome(nome);
        novaEquipe.setQuantidadeMembros(quantidade);
        novaEquipe.setIdTreinador(idTreinado);

        // 3. PERSISTÊNCIA: Mandamos o DAO de Equipe salvar no banco
        equipeDao.inserir(novaEquipe);

        System.out.println(" Treinador ID " + idTreinado + " criou a equipe " + nome + " com sucesso!");
    }


    public void deletarEquipe() {
        System.out.println("Ação: Removendo equipe selecionada...");
    }

    public void listarEquipe() {
        System.out.println("Ação: Listando todas as equipes do treinador...");
    }

    public void atualizarEquipe() {
        System.out.println("Ação: Editando dados da equipe...");
    }

    public void gerenciarAtletas() {
        System.out.println("Ação: Abrindo painel de atletas da equipe...");
    }

    public void atualizarRanking() {
        System.out.println("Ação: Calculando novas posições no Ranking...");
    }

}
