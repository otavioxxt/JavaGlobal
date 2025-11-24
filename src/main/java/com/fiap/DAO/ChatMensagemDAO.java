package com.fiap.DAO;

import com.fiap.conexao.ConexaoFactory;
import com.fiap.model.ChatMensagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatMensagemDAO {
    public Connection minhaConexao;

    public ChatMensagemDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(ChatMensagem chatMensagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Insert into Psicobit values (?, ?, ?)");
        stmt.setString(1, chatMensagem.getId());
        stmt.setString(2, chatMensagem.getConteudo());
        stmt.setString(3, chatMensagem.getDataenvio());

        stmt.execute();
        stmt.close();

        return "Mensagem de chat cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Delete from Psicobit where id = ?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Mensagem de caht deletado com sucesso!";
    }

    // UpDate
    public String atualizar(ChatMensagem chatMensagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update Psicobit set id = ?, conteudo = ?,where DataEnvio = ?");
        stmt.setString(1, chatMensagem.getId());
        stmt.setString(2, chatMensagem.getConteudo());
        stmt.setString(3, chatMensagem.getDataenvio());


        stmt.executeUpdate();
        stmt.close();

        return "Mensagem de chat atualizado com sucesso!";
    }

    // Select
    public List<ChatMensagem> selecionar() throws SQLException {
        List<ChatMensagem> listaChatMensagem = new ArrayList<ChatMensagem>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from Psicobit");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            ChatMensagem objChatMensagem = new ChatMensagem();
            objChatMensagem.setId(rs.getString(1));
            objChatMensagem.setConteudo(rs.getString(2));
            objChatMensagem.setDataenvio(rs.getString(3));
            listaChatMensagem.add(objChatMensagem);
        }

        return listaChatMensagem;
    }
}
