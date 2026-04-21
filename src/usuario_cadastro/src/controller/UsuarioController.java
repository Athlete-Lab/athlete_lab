package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    // CREATE
    public void cadastrar(Usuario u) {

        if (u == null) {
            System.out.println("Erro: usuário inválido.");
            return;
        }

        if (u.getIdUsuario() <= 0) {
            System.out.println("Erro: ID inválido.");
            return;
        }

        // ID duplicado
        for (Usuario user : usuarios) {
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

        // email duplicado
        for (Usuario user : usuarios) {
            if (user.getEmail().equalsIgnoreCase(u.getEmail())) {
                System.out.println("Erro: email já cadastrado.");
                return;
            }
        }

        if (u.getSenha() == null || u.getSenha().isEmpty()) {
            System.out.println("Erro: senha é obrigatória.");
            return;
        }

        if (u.getDataNascimento() == null) {
            System.out.println("Erro: data de nascimento é obrigatória.");
            return;
        }

        if (u.getCidadeUF() == null || u.getCidadeUF().isEmpty()) {
            System.out.println("Erro: cidade/UF é obrigatória.");
            return;
        }

        if (u.getDataCriacao() == null) {
            u.setDataCriacao(new Date());
        }

        u.setAtivo(true);

        usuarios.add(u);

        System.out.println("Usuário cadastrado: " + u.getNome());
    }

    // READ (LISTAR)
    public void listar() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de usuários ---");

        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    // READ (BUSCAR)
    public Usuario buscarPorId(int idUsuario) {

        if (idUsuario <= 0) {
            System.out.println("Erro: ID inválido.");
            return null;
        }

        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                return u;
            }
        }

        return null;
    }

    // UPDATE
    public void atualizar(Usuario usuarioAtualizado) {

        if (usuarioAtualizado == null) {
            System.out.println("Erro: usuário inválido.");
            return;
        }

        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == usuarioAtualizado.getIdUsuario()) {

                u.setNome(usuarioAtualizado.getNome());
                u.setEmail(usuarioAtualizado.getEmail());
                u.setTelefone(usuarioAtualizado.getTelefone());
                u.setCidadeUF(usuarioAtualizado.getCidadeUF());

                System.out.println("Usuário atualizado com sucesso.");
                return;
            }
        }

        System.out.println("Usuário não encontrado.");
    }

    // DELETE
    public void deletar(int idUsuario) {

        if (idUsuario <= 0) {
            System.out.println("Erro: ID inválido.");
            return;
        }

        boolean removido = usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);

        if (removido) {
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}