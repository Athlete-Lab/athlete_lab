package com.athletelab.usuario;

import com.athletelab.configBD.ConnectionDataBase;
import com.athletelab.usuario.UsuarioModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    // CREATE
    public void inserir(UsuarioModel u) {

        String sql = "INSERT INTO usuario(nome, email, telefone, cidade_uf, senha, data_nascimento, data_criacao, tipo_usuario, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getTelefone());
            stmt.setString(4, u.getCidadeUF());
            stmt.setString(5, u.getSenha());
            stmt.setDate(6, java.sql.Date.valueOf(u.getDataNascimento()));
            stmt.setDate(7, java.sql.Date.valueOf(u.getDataCriacao()));
            stmt.setString(8, u.getTipoUsuario());
            stmt.setBoolean(9, u.isAtivo());
            stmt.executeUpdate();

            System.out.println("Usuário salvo no banco.");

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir: " + erro.getMessage());
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

                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setCidadeUF(rs.getString("cidade_uf"));
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

        String sql = "UPDATE usuario SET nome=?, email=?, telefone=?, cidade_uf=?, senha=? WHERE idUsuario=?";

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

    public static UsuarioModel login(String email, String senha) {

        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ? ";

        try (Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs =  stmt.executeQuery();

            if (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setIdUsuario( rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                return usuario;
            }
            return null;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }

    }


}