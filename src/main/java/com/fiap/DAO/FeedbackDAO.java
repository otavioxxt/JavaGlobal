package com.fiap.DAO;

import com.fiap.model.Feedback;
import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public Connection minhaConexao;

    public FeedbackDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Feedback feedback) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, feedback.getId());
        stmt.setString(2, feedback.getNota());
        stmt.setString(3, feedback.getComentario());

        stmt.execute();
        stmt.close();

        return "Feedback cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Feedback deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Feedback feedback) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, nota = ?,where comentario = ?");
        stmt.setString(1, feedback.getId());
        stmt.setString(2, feedback.getNota());
        stmt.setString(3, feedback.getComentario());


        stmt.executeUpdate();
        stmt.close();

        return "Feedback atualizado com sucesso!";
    }

    // Select
    public List<Feedback> selecionar() throws SQLException {
        List<Feedback> listaFeedback = new ArrayList<Feedback>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Feedback objFeedback = new Feedback();
            objFeedback.setId(rs.getString(1));
            objFeedback.setNota(rs.getString(2));
            objFeedback.setComentario(rs.getString(3));
            listaFeedback.add(objFeedback);
        }

        return listaFeedback;
    }
}
