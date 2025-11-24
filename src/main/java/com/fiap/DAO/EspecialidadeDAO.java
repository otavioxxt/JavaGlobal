package com.fiap.DAO;

import com.fiap.conexao.ConexaoFactory;
import com.fiap.model.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {
    public Connection minhaConexao;

    public EspecialidadeDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Especialidade especialidade) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, especialidade.getId());
        stmt.setString(2, especialidade.getNome());
        stmt.setString(3, especialidade.getDescricao());

        stmt.execute();
        stmt.close();

        return "Especialidade cadastrada com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Especialidade deletada com sucesso!";
    }

    // UpDate
    public String atualizar(Especialidade especialidade) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, Nome = ?,where Descricao = ?");
        stmt.setString(1, especialidade.getId());
        stmt.setString(2, especialidade.getNome());
        stmt.setString(3, especialidade.getDescricao());


        stmt.executeUpdate();
        stmt.close();

        return "Feedback atualizado com sucesso!";
    }

    // Select
    public List<Especialidade> selecionar() throws SQLException {
        List<Especialidade> listaEspecialidade = new ArrayList<Especialidade>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Especialidade objEspecialidade = new Especialidade();
            objEspecialidade.setId(rs.getString(1));
            objEspecialidade.setNome(rs.getString(2));
            objEspecialidade.setDescricao(rs.getString(3));
            listaEspecialidade.add(objEspecialidade);
        }

        return listaEspecialidade;
    }
}
