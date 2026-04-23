package com.athletelab.equipe;

import com.athletelab.configBD.ConnectionDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDao {
    public void inserir(EquipeModel e) {
        String sql = "INSERT INTO equipe (nome, quantidade_membros, id_treinador) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setInt(2, e.getQuantidadeMembros());
            stmt.setInt(3, e.getIdTreinador());
            stmt.executeUpdate();
        } catch (SQLException err) { err.printStackTrace(); }
    }

    public List<EquipeModel> listarPorTreinador(int idTreinado) {
        List<EquipeModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipe WHERE id_treinador = ?";
        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTreinado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EquipeModel e = new EquipeModel();
                    e.setIdEquipe(rs.getInt("id_equipe"));
                    e.setNome(rs.getString("nome"));
                    lista.add(e);
                }
            }
        } catch (SQLException err) { err.printStackTrace(); }
        return lista;
    }

    public EquipeModel buscarPorId(int id) {
        String sql = "SELECT * FROM equipe WHERE id_equipe = ?";
        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EquipeModel e = new EquipeModel();
                    e.setIdEquipe(rs.getInt("id_equipe"));
                    e.setNome(rs.getString("nome"));
                    return e;
                }
            }
        } catch (SQLException err) { err.printStackTrace(); }
        return null;
    }

    public void atualizar(EquipeModel e) {
        String sql = "UPDATE equipe SET nome = ?, quantidade_membros = ? WHERE id_equipe = ?";
        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setInt(2, e.getQuantidadeMembros());
            stmt.setInt(3, e.getIdEquipe());
            stmt.executeUpdate();
        } catch (SQLException err) { err.printStackTrace(); }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM equipe WHERE id_equipe = ?";
        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException err) { err.printStackTrace(); }
    }

    public List<EquipeModel> listarTodas() {
        List<EquipeModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipe";

        try (Connection conn = ConnectionDataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EquipeModel e = new EquipeModel();
                e.setIdEquipe(rs.getInt("id_equipe"));
                e.setNome(rs.getString("nome"));
                e.setQuantidadeMembros(rs.getInt("quantidade_membros"));
                e.setIdTreinador(rs.getInt("id_treinador"));
                lista.add(e);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return lista;
    }
}
