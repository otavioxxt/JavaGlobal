package com.fiap.main;

import com.fiap.model.ChatMensagem;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayListChatMensagem {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) {

        ArrayList<ChatMensagem> listaChatMensagem = new ArrayList<ChatMensagem>();

        ChatMensagem objChatMensagem = null;

        do {

            objChatMensagem = new ChatMensagem();
            objChatMensagem.setId(texto("ID da Mensagem"));
            objChatMensagem.setConteudo(texto("Conteudo da Mensagem"));
            objChatMensagem.setDataenvio(texto("Data da Mensagem"));

            listaChatMensagem.add(objChatMensagem);

        } while ( JOptionPane.showConfirmDialog(
                null,
                "Cadastrar Mensagem?",
                "Cadastro de ChatMensagem",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        ) == 0);

        // Saídas com foreach
        for(ChatMensagem a : listaChatMensagem)
        {
            System.out.println(
                    "\nID: " + a.getId() +
                            "\nConteudo: " + a.getConteudo() +
                            "\nData de envio: " + a.getDataenvio()
            );
        }

    }

}

