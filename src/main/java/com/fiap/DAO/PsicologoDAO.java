package com.fiap.DAO;


import com.fiap.model.Psicologo;
import com.fiap.conexao.ConexaoFactory;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PsicologoDAO {
    public Connection minhaConexao;

    public PsicologoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Psicologo psicologo  ) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, psicologo.getId());
        stmt.setString(2, psicologo.getName());
        stmt.setString(3, psicologo.getRegistro());

        stmt.execute();
        stmt.close();

        return "Psicologo cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Psicologo deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Psicologo psicologo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, name = ?,where Registro = ?");
        stmt.setString(1, psicologo.getId());
        stmt.setString(2, psicologo.getName());
        stmt.setString(3, psicologo.getRegistro());


        stmt.executeUpdate();
        stmt.close();

        return "Psicologo atualizado com sucesso!";
    }

    // Select
    public List<Psicologo> selecionar() throws SQLException {
        List<Psicologo> listaPsicologo = new ArrayList<Psicologo>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Psicologo objPsicologo = new Psicologo();
            objPsicologo.setId(rs.getString(1));
            objPsicologo.setName(rs.getString(2));
            objPsicologo .setRegistro(rs.getString(3));
            listaPsicologo.add(objPsicologo);
        }

        return listaPsicologo;
    }
}



