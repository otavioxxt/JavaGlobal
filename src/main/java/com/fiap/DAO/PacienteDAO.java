package com.fiap.DAO;
import com.fiap.model.Paciente;
import com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO  {

    public Connection minhaConexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, paciente.getId());
        stmt.setString(2, paciente.getNome());
        stmt.setString(3, paciente.getEmail());

        stmt.execute();
        stmt.close();

        return "Aluno cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where RM = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Paciente deletado com sucesso!";
    }

    // UpDate
    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, nome = ?,where email = ?");
        stmt.setString(1, paciente.getNome());
        stmt.setString(2, paciente.getId());
        stmt.setString(3, paciente.getEmail());


        stmt.executeUpdate();
        stmt.close();

        return "Aluno atualizado com sucesso!";
    }

    // Select
    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> listaPaciente = new ArrayList<Paciente>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Paciente objPaciente = new Paciente();
            objPaciente.setId(rs.getString(1));
            objPaciente.setNome(rs.getString(2));
            objPaciente.setEmail(rs.getString(3));
            listaPaciente.add(objPaciente);
        }

        return listaPaciente;
    }
}

