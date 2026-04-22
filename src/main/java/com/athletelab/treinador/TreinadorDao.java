package com.athletelab.treinador;

import com.athletelab.configBD.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreinadorDao {
    public void inserir(TreinadorModel t) {
        // idUsuario é a FK que liga o Treinador ao Usuário (Herança no BD)
        String sql = "INSERT INTO treinador (idUsuario, ativo) VALUES (?, ?)";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getIdUsuario()); // Vem da herança de UsuarioModel
            stmt.setBoolean(2, t.isAtivo());

            stmt.executeUpdate();
            System.out.println(" Treinador inserido no banco com sucesso!");

        } catch (SQLException e) {
            System.out.println(" Erro ao inserir no TreinadorDao: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void salvar(TreinadorModel t) {
        String sql = "INSERT INTO treinador (idUsuario, ativo) VALUES (?, ?)";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getIdUsuario()); // Puxa da herança de Usuario
            stmt.setBoolean(2, t.isAtivo());

            stmt.executeUpdate();
            System.out.println(" Treinador salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println(" Erro no TreinadorDao: " + e.getMessage());
        }
    }

    public List<TreinadorModel> listar() {
        List<TreinadorModel> lista = new ArrayList<>();
        String sql = "SELECT t.*, u.nome FROM treinador t JOIN usuario u ON t.idUsuario = u.idUsuario";

        try (Connection conn = ConnectionDataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TreinadorModel t = new TreinadorModel();
                t.setIdTreinado(rs.getInt("idTreinado"));
                t.setIdUsuario(rs.getInt("idUsuario"));
                t.setNome(rs.getString("nome")); // Atributo do Usuario
                t.setAtivo(rs.getBoolean("ativo"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao listar treinadores: " + e.getMessage());
        }
        return lista;
    }
}
