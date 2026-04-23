package com.athletelab;

import com.athletelab.configBD.ConnectionDataBase;
import com.athletelab.usuario.UsuarioView;

public class Main {
    public static void main(String[] args) {
        UsuarioView usuarioView = new UsuarioView();
        ConnectionDataBase.TesteConexao();
        usuarioView.menuUsuario();
    }

}