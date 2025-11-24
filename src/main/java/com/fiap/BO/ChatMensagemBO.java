package com.fiap.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fiap.model.ChatMensagem;
import com.fiap.DAO.ChatMensagemDAO;

public class ChatMensagemBO {

    ChatMensagemDAO chatMensagemDAO;


    public ArrayList<ChatMensagem> selecionarBo() throws ClassNotFoundException, SQLException {
        chatMensagemDAO = new ChatMensagemDAO();


        return (ArrayList<ChatMensagem>) chatMensagemDAO.selecionar();
    }


    public void inserirBo(ChatMensagem chatMensagem) throws ClassNotFoundException, SQLException {
        ChatMensagemDAO chatMensagemDao = new ChatMensagemDAO();

        chatMensagemDao.inserir(chatMensagem);
    }


    public void atualizarBo (ChatMensagem chatMensagem) throws ClassNotFoundException, SQLException {
        ChatMensagemDAO chatMensagemDao = new ChatMensagemDAO();

        chatMensagemDao.atualizar(chatMensagem);
    }


    public void deletarBo (String id) throws ClassNotFoundException, SQLException {
        ChatMensagemDAO chatMensagemDao = new ChatMensagemDAO();

        chatMensagemDao.deletar(id);
    }

}
