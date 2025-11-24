package com.fiap.DAO;

import com.fiap.model.Sessao;
import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {

        public Connection minhaConexao;

        public SessaoDAO() throws SQLException, ClassNotFoundException {
            this.minhaConexao = new ConexaoFactory().conexao();
        }

        // Insert
        public String inserir(Sessao sessao) throws SQLException {
            PreparedStatement stmt = minhaConexao.prepareStatement
                    ("Insert into Psicobit values (?, ?, ?)");
            stmt.setString(1, sessao.getId());
            stmt.setString(2, sessao.getData());
            stmt.setString(3, sessao.getStatus());

            stmt.execute();
            stmt.close();

            return "Sessão cadastrado com sucesso!";
        }

        // Delete
        public String deletar(String id) throws SQLException {
            PreparedStatement stmt = minhaConexao.prepareStatement
                    ("Delete from Psicobit where id = ?");
            stmt.setString(1, id);

            stmt.execute();
            stmt.close();

            return "Sessao deletado com sucesso!";
        }

        // UpDate
        public String atualizar(Sessao sessao) throws SQLException {
            PreparedStatement stmt = minhaConexao.prepareStatement
                    ("Update Psicobit set id = ?, data = ?,where status = ?");
            stmt.setString(1, sessao.getId());
            stmt.setString(2, sessao.getData());
            stmt.setString(3, sessao.getStatus());


            stmt.executeUpdate();
            stmt.close();

            return "Psicologo atualizado com sucesso!";
        }

        // Select
        public List<Sessao> selecionar() throws SQLException {
            List<Sessao> listaSessao = new ArrayList<Sessao>();
            PreparedStatement stmt = minhaConexao.prepareStatement
                    ("select * from Psicobit");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Sessao objSessao = new Sessao();
                objSessao.setId(rs.getString(1));
                objSessao.setData(rs.getString(2));
                objSessao.setStatus(rs.getString(3));
                listaSessao.add(objSessao);
            }

            return listaSessao;
        }
    }

