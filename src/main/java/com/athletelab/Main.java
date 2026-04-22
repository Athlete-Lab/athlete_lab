package com.athletelab;

import com.athletelab.configBD.ConnectionDataBase;
import com.athletelab.treinador.TreinadorView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try {
            Connection conn = ConnectionDataBase.getConnection();

            if (conn != null && !conn.isClosed()) {
                System.out.println("BANCO CONECTADO COM SUCESSO!");
            }

        } catch (Exception e) {
            System.out.println("ERRO AO CONECTAR:");
            e.printStackTrace();
        }
        TreinadorView treinadorView = new TreinadorView();
        treinadorView.exibirMenu();

    }

}