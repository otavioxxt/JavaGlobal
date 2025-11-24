package com.fiap.DAO;

import com.fiap.conexao.ConexaoFactory;
import com.fiap.model.EmpresaParceira;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaParceiraDAO {
    public Connection minhaConexao;

    public EmpresaParceiraDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(EmpresaParceira empresaParceira) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, empresaParceira.getId());
        stmt.setString(2, empresaParceira.getNome());
        stmt.setString(3, empresaParceira.getNumFuncionarios());

        stmt.execute();
        stmt.close();

        return "Empresa cadastrada com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Empresa deletada com sucesso!";
    }

    // UpDate
    public String atualizar(EmpresaParceira empresaParceira) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, nome = ?,where NumFuncionarios = ?");
        stmt.setString(1, empresaParceira.getId());
        stmt.setString(2, empresaParceira.getNome());
        stmt.setString(3, empresaParceira.getNumFuncionarios());


        stmt.executeUpdate();
        stmt.close();

        return "Empresa atualizado com sucesso!";
    }

    // Select
    public List<EmpresaParceira> selecionar() throws SQLException {
        List<EmpresaParceira> listaEmpresaParceira = new ArrayList<EmpresaParceira>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            EmpresaParceira objEmpresaParceira = new EmpresaParceira();
            objEmpresaParceira.setId(rs.getString(1));
            objEmpresaParceira.setNome(rs.getString(2));
            objEmpresaParceira.setNumFuncionarios(rs.getString(3));
            listaEmpresaParceira.add(objEmpresaParceira);
        }

        return listaEmpresaParceira;
    }
}
