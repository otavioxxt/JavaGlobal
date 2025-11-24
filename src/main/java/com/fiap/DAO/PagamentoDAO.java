package com.fiap.DAO;

import com.fiap.model.Pagamento;
import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    public Connection minhaConexao;

    public PagamentoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Pagamento pagamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, pagamento.getId());
        stmt.setString(2, pagamento.getForma());
        stmt.setString(3, pagamento.getValor());

        stmt.execute();
        stmt.close();

        return "Pagamento cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Pagamento deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Pagamento pagamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, forma = ?,where valor = ?");
        stmt.setString(1, pagamento.getId());
        stmt.setString(2, pagamento.getForma());
        stmt.setString(3, pagamento.getValor());


        stmt.executeUpdate();
        stmt.close();

        return "Aluno atualizado com sucesso!";
    }

    // Select
    public List<Pagamento> selecionar() throws SQLException {
        List<Pagamento> listaPaciente = new ArrayList<Pagamento>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Pagamento objPaciente = new Pagamento();
            objPaciente.setId(rs.getString(1));
            objPaciente.setForma(rs.getString(2));
            objPaciente.setValor(rs.getString(3));
            listaPaciente.add(objPaciente);
        }

        return listaPaciente;
    }
}
