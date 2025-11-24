package com.fiap.DAO;

import com.fiap.conexao.ConexaoFactory;
import com.fiap.model.PlanoDeTratamento;
import org.h2.table.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanoDeTratamentoDAO {
    public Connection minhaConexao;

    public PlanoDeTratamentoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(PlanoDeTratamento planoDeTratamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, planoDeTratamento.getId());
        stmt.setString(2, planoDeTratamento.getObjetivo());
        stmt.setString(3, planoDeTratamento.getDuracao());

        stmt.execute();
        stmt.close();

        return "Plano cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Plano deletado com sucesso!";
    }

    // UpDate
    public String atualizar(PlanoDeTratamento planoDeTratamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, duracao = ?,where objetivo = ?");
        stmt.setString(1, planoDeTratamento.getId());
        stmt.setString(2, planoDeTratamento.getDuracao());
        stmt.setString(3, planoDeTratamento.getObjetivo());


        stmt.executeUpdate();
        stmt.close();

        return "Plano atualizado com sucesso!";
    }

    // Select
    public List<PlanoDeTratamento> selecionar() throws SQLException {
        List<PlanoDeTratamento> listaPlanoDeTratamento = new ArrayList<PlanoDeTratamento>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            PlanoDeTratamento objPlanoDeTratamento = new PlanoDeTratamento();
            objPlanoDeTratamento.setId(rs.getString(1));
            objPlanoDeTratamento.setObjetivo(rs.getString(2));
            objPlanoDeTratamento.setDuracao(rs.getString(3));
            listaPlanoDeTratamento.add(objPlanoDeTratamento);
        }

        return listaPlanoDeTratamento;
    }
}