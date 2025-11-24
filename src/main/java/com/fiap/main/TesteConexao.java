package com.fiap.main;

import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
public class TesteConexao {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection cn = new ConexaoFactory().conexao();

        System.out.println("Conectado com sucesso!");

        cn.close();

    }
}