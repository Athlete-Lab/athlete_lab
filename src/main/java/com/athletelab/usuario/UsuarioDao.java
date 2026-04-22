package com.athletelab.usuario;

import com.athletelab.configBD.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    // CREATE
    public void inserir(UsuarioModel u) {

        String sql = "INSERT INTO usuario (nome, email, telefone, cidadeUF, senha, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getTelefone());
            stmt.setString(4, u.getCidadeUF());
            stmt.setString(5, u.getSenha());
            stmt.setBoolean(6, u.isAtivo());

            stmt.executeUpdate();

            System.out.println("Usuário salvo no banco.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    // READ
    public List<UsuarioModel> listar() {

        List<UsuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = ConnectionDataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UsuarioModel u = new UsuarioModel();

                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setCidadeUF(rs.getString("cidadeUF"));
                u.setSenha(rs.getString("senha"));
                u.setAtivo(rs.getBoolean("ativo"));

                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    // UPDATE
    public void atualizar(UsuarioModel u) {

        String sql = "UPDATE usuario SET nome=?, email=?, telefone=?, cidadeUF=?, senha=? WHERE idUsuario=?";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getTelefone());
            stmt.setString(4, u.getCidadeUF());
            stmt.setString(5, u.getSenha());
            stmt.setInt(6, u.getIdUsuario());

            stmt.executeUpdate();

            System.out.println("Usuário atualizado no banco.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    // DELETE
    public void deletar(int idUsuario) {

        String sql = "DELETE FROM usuario WHERE idUsuario=?";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();

            System.out.println("Usuário removido do banco.");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}