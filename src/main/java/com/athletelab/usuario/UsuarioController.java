package com.athletelab.usuario;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class UsuarioController {

    private List<UsuarioModel> usuarios = new ArrayList<>();

    // CREATE
    public void cadastrar(UsuarioModel u) {

        if (u == null) {
            System.out.println("Erro: usuário inválido.");
            return;
        }

        // Verifica ID duplicado
        for (UsuarioModel user : usuarios) {
            if (user.getIdUsuario() == u.getIdUsuario()) {
                System.out.println("Erro: ID já cadastrado.");
                return;
            }
        }

        if (u.getNome() == null || u.getNome().isEmpty()) {
            System.out.println("Erro: nome é obrigatório.");
            return;
        }

        if (u.getEmail() == null || u.getEmail().isEmpty()) {
            System.out.println("Erro: email é obrigatório.");
            return;
        }

        // Verifica email duplicado
        for (UsuarioModel user : usuarios) {
            if (user.getEmail().equalsIgnoreCase(u.getEmail())) {
                System.out.println("Erro: email já cadastrado.");
                return;
            }
        }

        if (u.getSenha() == null || u.getSenha().isEmpty()) {
            System.out.println("Erro: senha é obrigatória.");
            return;
        }

        if(u.getTipoUsuario() == null || u.getTipoUsuario().isEmpty()){
            System.out.println("Erro: tipo de usuário é obrigatório.");
        }

        if (u.getCidadeUF() == null || u.getCidadeUF().isEmpty()) {
            System.out.println("Erro: cidade/UF é obrigatória.");
            return;
        }

        if (u.getDataNascimento() == null) {
            System.out.println("Erro: data de nascimento é obrigatória.");
            return;
        }

        // Define automaticamente
        if (u.getDataCriacao() == null) {
            u.setDataCriacao(LocalDate.now());
        }

        u.setAtivo(true);

        UsuarioDao dao = new UsuarioDao();
        dao.inserir(u);
        System.out.println("Usuário cadastrado: " + u.getNome());
    }

    // READ (LISTAR)
    public void listar() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de usuários ---");

        for (UsuarioModel u : usuarios) {
            System.out.println(
                u.getIdUsuario() + " - " +
                u.getNome() + " - " +
                u.getEmail() + " - " +
                u.getTipoUsuario() + " - " +
                u.getCidadeUF()
            );
        }
    }

    // READ (BUSCAR)
    public UsuarioModel buscarPorId(int idUsuario) {

        for (UsuarioModel u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                return u;
            }
        }

        return null;
    }

    // UPDATE
    public void atualizar(UsuarioModel atualizado) {

        for (UsuarioModel u : usuarios) {
            if (u.getIdUsuario() == atualizado.getIdUsuario()) {

                u.setNome(atualizado.getNome());
                u.setEmail(atualizado.getEmail());
                u.setTelefone(atualizado.getTelefone());
                u.setCidadeUF(atualizado.getCidadeUF());
                u.setSenha(atualizado.getSenha());

                System.out.println("Usuário atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Usuário não encontrado.");
    }

    // DELETE
    public void deletar(int idUsuario) {

        boolean removido = usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);

        if (removido) {
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // LOGIN TREINADOR
    public  UsuarioModel login(String email, String senha) {
        return UsuarioDao.login(email, senha);
    }
}

