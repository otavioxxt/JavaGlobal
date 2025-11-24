package com.fiap.DAO;

import com.fiap.model.Triagem;
import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TriagemDAO {
    public Connection minhaConexao;

    public TriagemDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Triagem triagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, triagem.getId());
        stmt.setString(2, triagem.getTipo());
        stmt.setString(3, triagem.getNvUrgencia());

        stmt.execute();
        stmt.close();

        return "Triagem cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Triagem deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Triagem triagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, tipo = ?,where NvUrgencia = ?");
        stmt.setString(1, triagem.getId());
        stmt.setString(2, triagem.getTipo());
        stmt.setString(3, triagem.getNvUrgencia());


        stmt.executeUpdate();
        stmt.close();

        return "Triagem atualizado com sucesso!";
    }

    // Select
    public List<Triagem> selecionar() throws SQLException {
        List<Triagem> listaAluno = new ArrayList<Triagem>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Triagem objTriagem = new Triagem();
            objTriagem.setId(rs.getString(1));
            objTriagem.setTipo(rs.getString(2));
            objTriagem.setNvUrgencia(rs.getString(3));
            listaAluno.add(objTriagem);
        }

        return listaAluno;
    }
}

